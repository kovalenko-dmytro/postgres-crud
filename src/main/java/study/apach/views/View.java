package study.apach.views;

import study.apach.views.representable.Representable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class View {

    private List<Object> data = new ArrayList<>();
    private Representable representable;

    public View(Representable representable) {
        this.representable = representable;
    }

    public void setData(Object entity) {
        data.add(entity);
    }

    public void setData(List<Object> data) {
        this.data.addAll(data);
    }


    public void render() {
        representable.render(data);
    }
}
