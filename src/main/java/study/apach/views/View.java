package study.apach.views;

import study.apach.views.representable.Representable;

import java.util.ArrayList;
import java.util.Collection;

public class View<T> {

    private Collection<T> data = new ArrayList<>();
    private Representable<T> representable;

    public View(Representable<T> representable) {
        this.representable = representable;
    }

    public void setData(T entity) {
        data.add(entity);
    }

    public void setData(Collection<T> data) {
        this.data.addAll(data);
    }


    public void render() {
        representable.render(data);
    }
}
