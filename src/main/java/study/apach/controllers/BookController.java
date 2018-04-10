package study.apach.controllers;

import study.apach.model.entities.Book;
import study.apach.model.services.BookServiceImpl;
import study.apach.model.services.EntityService;
import study.apach.views.View;
import study.apach.views.representable.ListView;
import study.apach.views.representable.SingleObjectView;

import java.util.ArrayList;

public class BookController {

    private EntityService<Book> bookService;

    public BookController() {
        this.bookService = new BookServiceImpl();
    }

    public void getBooks() {
        ArrayList<Book> books = (ArrayList<Book>) bookService.selectAllBooks();
        View<Book> listView = new View<>(new ListView<>());
        listView.setData(books);
        listView.render();
    }

    public void viewBook(long id) {
        Book book = bookService.selectById(id);
        View<Book> bookView = new View<>(new SingleObjectView<>());
        bookView.setData(book);
        bookView.render();
    }

    public void createBook(Book inputData) {
        bookService.insertBook(inputData);
    }

    public void updateBook(long id, Book inputData) {
        bookService.updateBook(id, inputData);
    }

    public void deleteBook(long id) {
        bookService.deleteBook(id);
    }
}
