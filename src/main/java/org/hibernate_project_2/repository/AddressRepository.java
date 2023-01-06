package org.hibernate_project_2.repository;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Address;
import org.hibernate_project_2.entity.Country;

import java.util.stream.Stream;

public class AddressRepository extends AbstractRepository<Address, Short> {

    public AddressRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public Stream<Address> find(Address entity) {
        return super.find(entity);
    }

    @Override
    public Address get(Short id) {
        return super.get(id);
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
