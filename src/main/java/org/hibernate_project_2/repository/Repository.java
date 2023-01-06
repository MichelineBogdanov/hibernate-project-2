package org.hibernate_project_2.repository;

import java.util.stream.Stream;

public interface Repository<T, N> {

    Stream<T> getAll();

    Stream<T> find(T entity);

    T get(N id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

}
