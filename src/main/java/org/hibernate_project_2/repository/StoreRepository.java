package org.hibernate_project_2.repository;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Store;

import java.util.stream.Stream;

public class StoreRepository extends AbstractRepository<Store, Byte> {

    public StoreRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Store.class);
    }

    @Override
    public Stream<Store> getAll() {
        return super.getAll();
    }

    @Override
    public Stream<Store> find(Store entity) {
        return super.find(entity);
    }

    @Override
    public Store get(Byte id) {
        return super.get(id);
    }

    @Override
    public void create(Store entity) {
        super.create(entity);
    }

    @Override
    public void update(Store entity) {
        super.update(entity);
    }

    @Override
    public void delete(Store entity) {
        super.delete(entity);
    }
}
