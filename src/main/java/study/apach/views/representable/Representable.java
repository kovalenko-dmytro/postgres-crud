package study.apach.views.representable;

import study.apach.model.entities.Book;
import study.apach.views.View;

import java.util.Collection;

public interface Representable<T> {

    void render(Collection<T> entities);

}
