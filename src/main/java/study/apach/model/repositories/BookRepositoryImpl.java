package study.apach.model.repositories;

import study.apach.model.db.DBManager;
import study.apach.model.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookRepositoryImpl implements BookRepository {

    private static final String SELECT_ALL_BOOKS = "SELECT b.id, b.title, b.author, b.cost, c.name " +
                                                    "FROM books b, categories c " +
                                                    "WHERE c.id = b.category_id";

    private static final String SELECT_BY_ID = SELECT_ALL_BOOKS + " AND b.id = ?";

    private static final String INSERT_BOOK = "INSERT INTO books (title, author, cost, category_id) " +
                                                "VALUES (?, ?, ?, ?)";

    private static final String UPDATE_BOOK = "UPDATE books " +
                                                "SET title = ?, author = ?, cost = ?, category_id = ? " +
                                                "WHERE id = ?";

    private static final String DELETE_BOOK = "DELETE FROM books " +
                                                "WHERE id = ?";

    private static final String SEARCH_BY_CATEGORY = "SELECT b.id, b.title, b.author, b.cost, c.name " +
                                                        "FROM books b, categories c " +
                                                        "WHERE b.category_id = ? AND c.id = b.category_id";

    @Override
    public Collection<Book> findAll() {

        ArrayList<Book> books = new ArrayList<>();
        Book book;

        try (Connection connection = DBManager.createConnection();
             Statement selectAllStatement = connection.createStatement()) {

            ResultSet rs = selectAllStatement.executeQuery(SELECT_ALL_BOOKS);

            while (rs.next()) {

                book = new Book();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCost(rs.getDouble("cost"));
                book.setCategoryName(rs.getString("name"));

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Book findOne(Long id) {

        Book book = new Book();

        try (Connection connection = DBManager.createConnection();
             PreparedStatement selectByIdStatement = connection.prepareStatement(SELECT_BY_ID)) {

            selectByIdStatement.setLong(1, id);
            ResultSet rs = selectByIdStatement.executeQuery();

            while (rs.next()) {

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCost(rs.getDouble("cost"));
                book.setCategoryName(rs.getString("name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public void save(Book entity) {

        try (Connection connection = DBManager.createConnection();
             PreparedStatement insertStatement = entity.getId() == 0
                ? connection.prepareStatement(INSERT_BOOK)
                : connection.prepareStatement(UPDATE_BOOK)) {

            insertStatement.setString(1, entity.getTitle());
            insertStatement.setString(2, entity.getAuthor());
            insertStatement.setDouble(3, entity.getCost());
            insertStatement.setLong(4, entity.getCategoryId());
            if (entity.getId() != 0) {
                insertStatement.setLong(5, entity.getId());
            }
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {

        try (Connection connection = DBManager.createConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(DELETE_BOOK)) {

            deleteStatement.setLong(1, id);
            deleteStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Book> findByCategory(long categoryId) {

        ArrayList<Book> books = new ArrayList<>();
        Book book;

        try (Connection connection = DBManager.createConnection();
             PreparedStatement searchStatement = connection.prepareStatement(SEARCH_BY_CATEGORY)) {

            searchStatement.setLong(1, categoryId);
            ResultSet rs = searchStatement.executeQuery();

            while (rs.next()) {

                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCost(rs.getDouble("cost"));
                book.setCategoryName(rs.getString("name"));
                books.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
