package org.hibernate_project_2.repository;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Customer;

import java.util.stream.Stream;

public class CustomerRepository extends AbstractRepository<Customer, Short> {

    public CustomerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }

    @Override
    public Stream<Customer> getAll() {
        return super.getAll();
    }

    @Override
    public Stream<Customer> find(Customer entity) {
        return super.find(entity);
    }

    @Override
    public Customer get(Short id) {
        return super.get(id);
    }

}
