package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Customer;

import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer, Short> {

    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }

    @Override
    public List<Customer> getAll() {
        return super.getAll();
    }

    @Override
    public List<Customer> findByCriteria(Customer entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Customer getById(Short id) {
        return super.getById(id);
    }

}
