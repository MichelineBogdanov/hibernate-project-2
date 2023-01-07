package org.hibernate_project_2.dao;

import java.util.List;

public interface Repository<T, N> {

    List<T> getAll();

    List<T> findByCriteria(T entity);

    T getById(N id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

}
