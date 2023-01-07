package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Country;

import java.util.List;

public class CountryDAO extends AbstractDAO<Country, Short> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Country.class);
    }

    @Override
    public List<Country> getAll() {
        return super.getAll();
    }

    @Override
    public List<Country> findByCriteria(Country entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Country getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Country entity) {
        super.create(entity);
    }

    @Override
    public void update(Country entity) {
        super.update(entity);
    }

    @Override
    public void delete(Country entity) {
        super.delete(entity);
    }
}
