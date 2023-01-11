package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Rental;

import java.util.List;

public class RentalDAO extends AbstractDAO<Rental, Short> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Rental.class);
    }

    @Override
    public List<Rental> getAll() {
        return super.getAll();
    }

    @Override
    public List<Rental> findByCriteria(Rental entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Rental getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Rental entity) {
        super.create(entity);
    }

    @Override
    public void update(Rental entity) {
        super.update(entity);
    }

    @Override
    public void delete(Rental entity) {
        super.delete(entity);
    }
}
