package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public List<Inventory> getInventoryByFilmIdAndStoreId (Short filmId, Byte storeId) {
        Query<Inventory> query = getSession().createQuery(
                "select i from Inventory i where i.id in " +
                        "(select distinct r.inventory from Rental r where r.inventory in " +
                        "(select i.id from Inventory i where i.film.id = :FILM_ID and i.store.id = :STORE_ID) " +
                        "and r.returnDate is not null)",
                Inventory.class);
        query.setParameter("FILM_ID", filmId);
        query.setParameter("STORE_ID", storeId);
        return query.list();
    }
}
