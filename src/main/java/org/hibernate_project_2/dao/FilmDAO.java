package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate_project_2.entity.Film;

import java.util.List;

public class FilmDAO extends AbstractDAO<Film, Short> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Film.class);
    }

    @Override
    public List<Film> getAll() {
        return super.getAll();
    }

    @Override
    public List<Film> findByCriteria(Film entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Film getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Film entity) {
        super.create(entity);
    }

    @Override
    public void update(Film entity) {
        super.update(entity);
    }

    @Override
    public void delete(Film entity) {
        super.delete(entity);
    }

    public Film getAvailableFilm() {
        Query<Film> query = getSession().createQuery("select f from Film f " +
                "where f.id not in (select film.id from Inventory)", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
