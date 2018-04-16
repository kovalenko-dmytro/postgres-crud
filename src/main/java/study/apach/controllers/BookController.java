package study.apach.controllers;

import study.apach.model.entities.Book;
import study.apach.model.services.BookServiceImpl;
import study.apach.model.services.BookService;
import study.apach.views.View;
import study.apach.views.representable.BookListView;
import study.apach.views.representable.SingleObjectView;

import java.util.ArrayList;
import java.util.Map;

public class BookController {

    private BookService bookService;

    public BookController() {
        bookService = new BookServiceImpl();
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void getBooks() {
        ArrayList<Book> books = (ArrayList<Book>) bookService.selectAll();
        View listView = new View(new BookListView());
        listView.setData(books);
        listView.render();
    }

    public void viewBook(long id) {
        Book book = bookService.selectById(id);
        View bookView = new View(new SingleObjectView());
        bookView.setData(book);
        bookView.render();
    }

    public void createBook(Map<String, Object> params) {
        bookService.insertBook(params);
    }

    public void updateBook(long id, Map<String, Object> params) {
        bookService.updateBook(id, params);
    }

    public void deleteBook(long id) {
        bookService.deleteBook(id);
    }

    public void getBooks(String categoryName) {
        ArrayList<Book> books = (ArrayList<Book>) bookService.searchBooksByCategory(categoryName);
        View listView = new View(new BookListView());
        listView.setData(books);
        listView.render();
    }
}
