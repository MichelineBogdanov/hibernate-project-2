package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Language;

import java.util.List;

public class LanguageDAO extends AbstractDAO<Language, Short> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Language.class);
    }

    @Override
    public List<Language> findByCriteria(Language entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Language getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Language entity) {
        super.create(entity);
    }

    @Override
    public void update(Language entity) {
        super.update(entity);
    }

    @Override
    public void delete(Language entity) {
        super.delete(entity);
    }
}
