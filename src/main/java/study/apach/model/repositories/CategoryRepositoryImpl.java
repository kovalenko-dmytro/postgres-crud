package study.apach.model.repositories;

import study.apach.model.db.DBManager;
import study.apach.model.entities.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String SELECT_ALL_CATEGORIES ="SELECT id, name FROM categories";
    private static final String SELECT_BY_NAME = "SELECT id, name FROM categories WHERE name = ?";

    @Override
    public Collection<Category> findAll() {

        ArrayList<Category> categories = new ArrayList<>();
        Category category;

        try (Connection connection = DBManager.createConnection();
             Statement selectAllStatement = connection.createStatement()) {

            ResultSet rs = selectAllStatement.executeQuery(SELECT_ALL_CATEGORIES);

            while (rs.next()) {

                category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category findOne(Long id) {
        return null;
    }

    @Override
    public void save(Category entity) {

    }

    @Override
    public void delete(Long id) {

    }


    @Override
    public Category findByName(String nameCategory) {

        Category category = null;

        try (Connection connection = DBManager.createConnection();
             PreparedStatement findStatement = connection.prepareStatement(SELECT_BY_NAME)) {

            findStatement.setString(1, nameCategory);
            ResultSet rs = findStatement.executeQuery();

            while (rs.next()) {

                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
}
