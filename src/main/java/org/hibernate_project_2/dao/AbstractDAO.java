package org.hibernate_project_2.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        List<Predicate> predicates = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String name = field.getName();
                Object value = field.get(entity);
                if (Objects.nonNull(value) && field.getType() == String.class) {
                    Predicate condition = criteriaBuilder.equal(root.get(name), value);
                    predicates.add(condition);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        query = query.where(predicates.toArray(Predicate[]::new));
        return getSession().createQuery(query).list();
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
