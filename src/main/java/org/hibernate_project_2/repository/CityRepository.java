package org.hibernate_project_2.repository;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.City;
import org.hibernate_project_2.entity.Country;

import java.util.stream.Stream;

public class CityRepository extends AbstractRepository<City, Short> {

    public CityRepository(SessionFactory sessionFactory) {
        super(sessionFactory, City.class);
    }

    @Override
    public Stream<City> getAll() {
        return super.getAll();
    }

    @Override
    public Stream<City> find(City entity) {
        return super.find(entity);
    }

    @Override
    public City get(Short id) {
        return super.get(id);
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
