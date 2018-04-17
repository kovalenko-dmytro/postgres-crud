package study.apach.views.representable;

import study.apach.model.entities.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryListView implements Representable {

    @Override
    public void render(Collection<Object> data) {

        List<Category> categories = new ArrayList<>();
        for (Object o : data) {
            categories.add((Category) o);
        }

        System.out.println("existing categories: ");
        for (Category category : categories) {
            System.out.println(" - " + category.getName());
        }
    }
}
