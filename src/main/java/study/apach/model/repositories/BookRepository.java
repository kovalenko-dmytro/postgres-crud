package study.apach.model.repositories;

import study.apach.model.entities.Book;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, Long> {

    Collection<Book> findByCategory(long categoryId);
}
