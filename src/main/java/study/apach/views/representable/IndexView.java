package study.apach.views.representable;

import java.util.Collection;

public class IndexView implements Representable {

    @Override
    public void render(Collection<Object> data) {
        System.out.println("**********************************************");
        System.out.println("|            BOOKS INDEX PAGE                |");
        System.out.println("**********************************************");
        System.out.println("| Options:                                   |");
        System.out.println("|        'list'.   View list of books        |");
        System.out.println("|        'sbn'.    search book by category   |");
        System.out.println("|        'create'. Create book               |");
        System.out.println("|        'exit'.   Exit                      |");
        System.out.println("**********************************************");
    }
}
