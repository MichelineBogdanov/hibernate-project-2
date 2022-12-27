package org.hibernate_project_2.repository;

import java.util.List;
import java.util.stream.Stream;

public interface AbstractRepository<T> {

    List<T> getAll();

    Stream<T> find(T t);



}
