package study.apach.views.representable;

import study.apach.model.entities.Book;
import study.apach.views.View;

import java.util.Collection;
import java.util.List;

public interface Representable {

    void render(List<Object> entities);

}
