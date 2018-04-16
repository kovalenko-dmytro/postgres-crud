package study.apach.model.repositories;

import study.apach.model.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String nameCategory);
}
