package study.apach.model.services;

import study.apach.model.entities.Book;
import study.apach.model.repositories.BookRepository;
import study.apach.model.repositories.BookRepositoryImpl;

import java.util.Collection;
import java.util.Map;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
    }

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Collection<Book> selectAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book selectById(long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void insertBook(Map<String, Object> params) {
        Book insertedBook = populateBookData(-1, params);
        bookRepository.save(insertedBook);
    }

    @Override
    public void updateBook(long id, Map<String, Object> params) {
        Book updatedBook = populateBookData(id, params);
        bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.delete(id);
    }

    private Book populateBookData(long id, Map<String, Object> params) {
        Book book = bookRepository.findOne(id) == null ? new Book() : bookRepository.findOne(id);
        book.setTitle((String) params.get("title"));
        book.setAuthor((String) params.get("author"));
        book.setCost(Double.parseDouble((String) params.get("cost")));

        return book;
    }
}
