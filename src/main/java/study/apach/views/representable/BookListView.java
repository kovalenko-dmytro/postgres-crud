package study.apach.views.representable;

import study.apach.model.entities.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookListView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        Collection<Book> books = new ArrayList<>();
        for (Object o : data) {
            books.add((Book) o);
        }

        System.out.println("*****************************************");
        System.out.println("|            LIST OF BOOKS              |");
        System.out.println("*****************************************");
        if (data.isEmpty()) {
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|       NO BOOKS ARE AVAILABLE          |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
        } else {
            System.out.println("|                                       |");
            System.out.println("|                                       |");

            books.forEach(book -> {
                System.out.println("id: " + book.getId() +
                                    " title: " + book.getTitle() +
                                    " author: " + book.getAuthor() +
                                    " cost: " + book.getCost());
            });

            System.out.println("|                                       |");
            System.out.println("|                                       |");
        }
        System.out.println("*****************************************");
    }
}