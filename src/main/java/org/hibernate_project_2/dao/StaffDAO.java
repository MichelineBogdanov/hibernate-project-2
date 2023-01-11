package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Staff;

import java.util.List;

public class StaffDAO extends AbstractDAO<Staff, Short> {

    public StaffDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Staff.class);
    }

    @Override
    public List<Staff> findByCriteria(Staff entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Staff getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Staff entity) {
        super.create(entity);
    }

    @Override
    public void update(Staff entity) {
        super.update(entity);
    }

    @Override
    public void delete(Staff entity) {
        super.delete(entity);
    }
}
