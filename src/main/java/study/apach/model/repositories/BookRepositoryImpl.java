package study.apach.model.repositories;

import study.apach.model.db.DBManager;
import study.apach.model.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookRepositoryImpl implements BookRepository {

    private static final String SELECT_ALL_BOOKS = "SELECT id, title, author, cost FROM books";
    private static final String SELECT_BY_ID = SELECT_ALL_BOOKS + " WHERE id = ?";
    private static final String INSERT_BOOK = "INSERT INTO books (title, author, cost) VALUES (?, ?, ?)";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ?, cost = ? WHERE id = ?";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";

    @Override
    public Collection<Book> findAll() {
        Connection connection = DBManager.createConnection();
        ArrayList<Book> books = new ArrayList<>();
        Book book;

        try (Statement selectAllStatement = connection.createStatement()) {

            ResultSet rs = selectAllStatement.executeQuery(SELECT_ALL_BOOKS);

            while (rs.next()) {

                book = new Book();

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCost(rs.getDouble("cost"));

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Book findOne(Long id) {
        Connection connection = DBManager.createConnection();
        Book book = new Book();

        try (PreparedStatement selectByIdStatement = connection.prepareStatement(SELECT_BY_ID)) {

            selectByIdStatement.setLong(1, id);
            ResultSet rs = selectByIdStatement.executeQuery();

            while (rs.next()) {

                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCost(rs.getDouble("cost"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public void save(Book entity) {

        Connection connection = DBManager.createConnection();

        try (PreparedStatement insertStatement = entity.getId() == 0
                ? connection.prepareStatement(INSERT_BOOK)
                : connection.prepareStatement(UPDATE_BOOK)) {

            insertStatement.setString(1, entity.getTitle());
            insertStatement.setString(2, entity.getAuthor());
            insertStatement.setDouble(3, entity.getCost());
            if (entity.getId() != 0) {
                insertStatement.setLong(4, entity.getId());
            }
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        Connection connection = DBManager.createConnection();

        try (PreparedStatement deleteStatement = connection.prepareStatement(DELETE_BOOK)) {

            deleteStatement.setLong(1, id);
            deleteStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
