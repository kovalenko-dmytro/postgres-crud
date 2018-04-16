package study.apach.model.services;

import study.apach.model.entities.Category;

import java.util.Collection;

public interface CategoryService {

    Collection<Category> selectAll();

}
