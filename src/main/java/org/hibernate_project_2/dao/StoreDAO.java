package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Store;

import java.util.List;

public class StoreDAO extends AbstractDAO<Store, Byte> {

    public StoreDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Store.class);
    }

    @Override
    public List<Store> getAll() {
        return super.getAll();
    }

    @Override
    public List<Store> findByCriteria(Store entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Store getById(Byte id) {
        return super.getById(id);
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
