package study.apach.views.representable;

import study.apach.model.entities.Book;

import java.util.Collection;

public class SingleObjectView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        Book book = (Book) data.iterator().next();

        System.out.println("*****************************************");
        if (data.isEmpty()) {
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|       NO SUCH BOOK IS AVAILABLE       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
        } else {
            System.out.println("id: " + book.getId());
            System.out.println("title: " + book.getTitle());
            System.out.println("author: " + book.getAuthor());
            System.out.println("cost: " + book.getCost());
        }
        System.out.println("*****************************************");
    }
}
