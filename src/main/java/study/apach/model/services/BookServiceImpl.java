package study.apach.model.services;

import study.apach.model.db.DBManager;
import study.apach.model.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class BookServiceImpl implements EntityService<Book> {

    private static final String SELECT_ALL_BOOKS = "SELECT id, title, author, cost FROM books";
    private static final String SELECT_BY_ID = SELECT_ALL_BOOKS + " WHERE id = ?";
    private static final String INSERT_BOOK = "INSERT INTO books (title, author, cost) VALUES (?, ?, ?)";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ?, cost = ? WHERE id = ?";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";

    @Override
    public Collection<Book> selectAllBooks() {

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
    public Book selectById(long id) {

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
    public void insertBook(Book inputData) {

        Connection connection = DBManager.createConnection();

        try (PreparedStatement insertStatement = connection.prepareStatement(INSERT_BOOK)) {

            insertStatement.setString(1, inputData.getTitle());
            insertStatement.setString(2, inputData.getAuthor());
            insertStatement.setDouble(3, inputData.getCost());
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(long id, Book inputData) {

        Connection connection = DBManager.createConnection();

        try (PreparedStatement updateStatement = connection.prepareStatement(UPDATE_BOOK)) {

            updateStatement.setString(1, inputData.getTitle());
            updateStatement.setString(2, inputData.getAuthor());
            updateStatement.setDouble(3, inputData.getCost());
            updateStatement.setLong(4, id);
            updateStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(long id) {
        Connection connection = DBManager.createConnection();

        try (PreparedStatement deleteStatement = connection.prepareStatement(DELETE_BOOK)) {

            deleteStatement.setLong(1, id);
            deleteStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
