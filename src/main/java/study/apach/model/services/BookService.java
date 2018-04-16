package study.apach.model.services;

import study.apach.model.entities.Book;

import java.util.Collection;
import java.util.Map;

public interface BookService {

    Collection<Book> selectAll();
    Book selectById(long id);
    void insertBook(Map<String, Object> params);
    void updateBook(long id, Map<String, Object> params);
    void deleteBook(long id);
    Collection<Book> searchBooksByCategory(String categoryName);

}
