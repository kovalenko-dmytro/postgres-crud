package study.apach.views.representable;

import study.apach.model.entities.Book;

import java.util.Collection;
import java.util.Iterator;

public class SingleObjectView<T> implements Representable<T> {

    @Override
    public void render(Collection<T> entities) {

        System.out.println("*****************************************");
        if (entities.isEmpty()) {
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
            System.out.println(entities);
        }
        System.out.println("*****************************************");
    }
}
