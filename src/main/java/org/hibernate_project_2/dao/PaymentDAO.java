package org.hibernate_project_2.dao;

import org.hibernate.SessionFactory;
import org.hibernate_project_2.entity.Payment;

import java.util.List;

public class PaymentDAO extends AbstractDAO<Payment, Short> {

    public PaymentDAO(SessionFactory sessionFactory) {
        super(sessionFactory, Payment.class);
    }

    @Override
    public List<Payment> findByCriteria(Payment entity) {
        return super.findByCriteria(entity);
    }

    @Override
    public Payment getById(Short id) {
        return super.getById(id);
    }

    @Override
    public void create(Payment entity) {
        super.create(entity);
    }

    @Override
    public void update(Payment entity) {
        super.update(entity);
    }

    @Override
    public void delete(Payment entity) {
        super.delete(entity);
    }
}
