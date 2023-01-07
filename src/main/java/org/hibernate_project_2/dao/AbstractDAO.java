package org.hibernate_project_2.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class AbstractDAO<T, N extends Number> implements Repository<T, N> {

    final SessionFactory sessionFactory;
    final Class<T> clazz;

    public AbstractDAO(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public List<T> getAll() {
        String hql = "select e from " + clazz.getSimpleName() + " e";
        Query<T> queryAll = getSession().createQuery(hql, clazz);
        return queryAll.list();
    }

    @Override
    public List<T> findByCriteria(T entity) {
        return null;
    }

    public T getById(N id) {
        return getSession().get(clazz, id);
    }

    @Override
    public void create(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
