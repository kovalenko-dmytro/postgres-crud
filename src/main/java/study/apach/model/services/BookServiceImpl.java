package study.apach.model.services;

import study.apach.model.entities.Book;
import study.apach.model.entities.Category;
import study.apach.model.repositories.BookRepository;
import study.apach.model.repositories.BookRepositoryImpl;
import study.apach.model.repositories.CategoryRepository;
import study.apach.model.repositories.CategoryRepositoryImpl;

import java.util.Collection;
import java.util.Map;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        categoryRepository = new CategoryRepositoryImpl();
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

    @Override
    public Collection<Book> searchBooksByCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return bookRepository.findByCategory(category.getId());
    }

    private Book populateBookData(long id, Map<String, Object> params) {

        Book book = bookRepository.findOne(id) == null ? new Book() : bookRepository.findOne(id);
        long categoryId = categoryRepository.findByName((String)params.get("category")).getId();

        book.setTitle((String) params.get("title"));
        book.setAuthor((String) params.get("author"));
        book.setCost(Double.parseDouble((String) params.get("cost")));
        book.setCategoryId(categoryId);

        return book;
    }
}
