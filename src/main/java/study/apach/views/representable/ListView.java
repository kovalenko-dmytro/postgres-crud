package study.apach.views.representable;

import study.apach.model.entities.Book;
import study.apach.views.View;

import java.util.Collection;

public class ListView<T> implements Representable<T> {

    @Override
    public void render(Collection<T> entities) {
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
