package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.FilmText;

public class FilmTextDAO extends AbstractDAO<FilmText, Short> {

    public FilmTextDAO(SessionFactory sessionFactory) {
        super(sessionFactory, FilmText.class);
    }

}
