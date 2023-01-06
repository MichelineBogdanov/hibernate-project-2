package org.hibernate_project_2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.stream.Stream;

public abstract class AbstractRepository<T, N extends Number> implements Repository<T, N> {

    final SessionFactory sessionFactory;
    final Class<T> clazz;

    public AbstractRepository(SessionFactory sessionFactory, Class<T> clazz) {
        this.sessionFactory = sessionFactory;
        this.clazz = clazz;
    }

    @Override
    public Stream<T> getAll() {
        return null;
    }

    @Override
    public Stream<T> find(T entity) {
        return null;
    }

    public T get(N id) {
        return sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public void create(T entity) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }
}
