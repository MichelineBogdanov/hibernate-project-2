package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Actor;

import java.util.List;

public class ActorDAO extends AbstractDAO<Actor, Short> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Actor.class);
    }

    @Override
    public List<Actor> findByCriteria(Actor entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Actor getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Actor entity) {
        super.create(entity);
    }

    @Override
    public void update(Actor entity) {
        super.update(entity);
    }

    @Override
    public void delete(Actor entity) {
        super.delete(entity);
    }
}
