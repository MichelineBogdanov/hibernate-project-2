package org.hibernate_project_2.repository;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Country;
import org.hibernate_project_2.entity.Customer;

import java.util.stream.Stream;

public class CountryRepository extends AbstractRepository<Country, Short> {

    public CountryRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Country.class);
    }

    @Override
    public Stream<Country> getAll() {
        return super.getAll();
    }

    @Override
    public Stream<Country> find(Country entity) {
        return super.find(entity);
    }

    @Override
    public Country get(Short id) {
        return super.get(id);
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
