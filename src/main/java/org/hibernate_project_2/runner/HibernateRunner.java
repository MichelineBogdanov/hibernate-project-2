package org.hibernate_project_2.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate_project_2.entity.Customer;
import org.hibernate_project_2.dao.*;
import org.hibernate_project_2.entity.Store;

import java.util.List;

public class HibernateRunner {

    private final SessionFactory sessionFactory;
    private final CustomerDAO customerDAO;
    private final AddressDAO addressDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final StoreDAO storeDAO;

    public HibernateRunner() {
        sessionFactory = SessionCreator.getSessionFactory();
        customerDAO = new CustomerDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();
        System.out.println(hibernateRunner.getCustomer((short) 1));
        System.out.println(hibernateRunner.getCustomer((short) 2));

        try (Session session = hibernateRunner.sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Store> all = hibernateRunner.storeDAO.getAll();
            for (Store store : all) {
                System.out.println(store);
            }
            transaction.commit();
        }

    }

    private Customer getCustomer(short i) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = customerDAO.getById(i);
            transaction.commit();
            return customer;
        }
    }

    private void createCustomer() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Customer customer = new Customer();

            transaction.commit();
        }
    }
}
