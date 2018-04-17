package study.apach.views.representable;

import study.apach.model.entities.Book;

import java.util.*;

public class BookListView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        List<Book> books = new ArrayList<>();
        for (Object o : data) {
            books.add((Book) o);
        }

        books.sort(Comparator.comparingLong((Book::getId)));

        System.out.println("*******************************************************");
        System.out.println("|                   LIST OF BOOKS                     |");
        System.out.println("*******************************************************");
        if (data.isEmpty()) {

            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("|              NO BOOKS ARE AVAILABLE                 |");
            System.out.println("|                                                     |");
            System.out.println("|                                                     |");
            System.out.println("*******************************************************");
            System.out.println();
            System.out.println("Back to index? [index]");

        } else {

            books.forEach(book -> {
                System.out.println("id: " + book.getId() + " | " +
                                    " title: " + book.getTitle() + " | " +
                                    " author: " + book.getAuthor() + " | " +
                                    " category: " + book.getCategoryName() + " | " +
                                    " cost: " + book.getCost());
            });
            System.out.println();
            System.out.println("Back to index? [index], " +
                                "View book? [id]");

        }
    }
}
