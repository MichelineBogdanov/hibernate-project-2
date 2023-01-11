package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Inventory;

import java.util.List;

public class InventoryDAO extends AbstractDAO<Inventory, Short> {

    public InventoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Inventory.class);
    }

    @Override
    public List<Inventory> findByCriteria(Inventory entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Inventory getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Inventory entity) {
        super.create(entity);
    }

    @Override
    public void update(Inventory entity) {
        super.update(entity);
    }

    @Override
    public void delete(Inventory entity) {
        super.delete(entity);
    }
}
