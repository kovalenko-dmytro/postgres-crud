package study.apach.views.representable;

import study.apach.model.entities.Book;
import study.apach.views.View;

import java.util.Collection;
import java.util.List;

public class BookListView implements Representable {

    @Override
    public void render(List<Object> entities) {


        System.out.println("*****************************************");
        System.out.println("|            LIST OF BOOKS              |");
        System.out.println("*****************************************");
        if (entities.isEmpty()) {
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

            entities.forEach(System.out::println);

            System.out.println("|                                       |");
            System.out.println("|                                       |");
        }
        System.out.println("*****************************************");
    }
}
