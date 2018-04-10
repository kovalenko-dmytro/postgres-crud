package study.apach.views.representable;

import study.apach.model.entities.Book;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SingleObjectView implements Representable {

    @Override
    public void render(List<Object> entities) {

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
