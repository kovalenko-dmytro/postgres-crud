package study.apach.model.services;

import study.apach.model.entities.Book;

import java.util.Collection;

public interface EntityService<T> {

    Collection<T> selectAllBooks();
    T selectById(long id);
    void insertBook(T inputData);
    void updateBook(long id, T inputData);
    void deleteBook(long id);
}
