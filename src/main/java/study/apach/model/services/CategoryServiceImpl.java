package study.apach.model.services;

import study.apach.model.entities.Category;
import study.apach.model.repositories.CategoryRepository;
import study.apach.model.repositories.CategoryRepositoryImpl;

import java.util.Collection;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl() {
        categoryRepository = new CategoryRepositoryImpl();
    }

    @Override
    public Collection<Category> selectAll() {
        return categoryRepository.findAll();
    }
}
