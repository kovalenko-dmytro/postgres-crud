package study.apach.controllers;

import study.apach.model.entities.Category;
import study.apach.model.services.CategoryService;
import study.apach.model.services.CategoryServiceImpl;
import study.apach.views.View;
import study.apach.views.representable.CategoryListView;

import java.util.ArrayList;

public class CategoryController {

    private CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryServiceImpl();
    }

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void getCategories() {

        ArrayList<Category> categories = (ArrayList<Category>) categoryService.selectAll();
        View categoryView = new View(new CategoryListView());
        categoryView.setData(categories);
        categoryView.render();

    }
}
