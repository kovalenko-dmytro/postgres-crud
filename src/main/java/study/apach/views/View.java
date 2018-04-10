package study.apach.views;

import study.apach.views.representable.Representable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class View {

    private Collection<Object> dataCollection = new ArrayList<>();
    private Representable representable;

    public View(Representable representable) {
        this.representable = representable;
    }

    public void setData(Object data) {
        if (data instanceof Collection) {
        dataCollection.addAll((Collection<?>) data);
        } else {
            dataCollection.add(data);
        }
    }

    public void render() {
        representable.render(dataCollection);
    }
}
