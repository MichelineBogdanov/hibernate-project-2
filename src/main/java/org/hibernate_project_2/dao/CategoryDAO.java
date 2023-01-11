package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Category;

import java.util.List;

public class CategoryDAO extends AbstractDAO<Category, Short> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Category.class);
    }

    @Override
    public List<Category> getAll() {
        return super.getAll();
    }

    @Override
    public List<Category> findByCriteria(Category entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Category getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Category entity) {
        super.create(entity);
    }

    @Override
    public void update(Category entity) {
        super.update(entity);
    }

    @Override
    public void delete(Category entity) {
        super.delete(entity);
    }
}
