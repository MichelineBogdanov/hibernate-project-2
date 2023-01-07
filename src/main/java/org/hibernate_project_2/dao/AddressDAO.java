package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Address;

import java.util.List;

public class AddressDAO extends AbstractDAO<Address, Short> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public List<Address> getAll() {
        return super.getAll();
    }

    @Override
    public List<Address> findByCriteria(Address entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Address getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Address entity) {
        super.create(entity);
    }

    @Override
    public void update(Address entity) {
        super.update(entity);
    }

    @Override
    public void delete(Address entity) {
        super.delete(entity);
    }
}
