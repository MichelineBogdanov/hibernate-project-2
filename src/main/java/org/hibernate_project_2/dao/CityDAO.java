package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.City;

import java.util.List;

public class CityDAO extends AbstractDAO<City, Short> {

    public CityDAO(SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

    @Override
    public List<City> getAll() {
        return super.getAll();
    }

    @Override
    public List<City> findByCriteria(City entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public City getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(City entity) {
        super.create(entity);
    }

    @Override
    public void update(City entity) {
        super.update(entity);
    }

    @Override
    public void delete(City entity) {
        super.delete(entity);
    }
}
