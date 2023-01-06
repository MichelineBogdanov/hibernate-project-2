package org.hibernate_project_2.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate_project_2.entity.Customer;
import org.hibernate_project_2.repository.*;

public class HibernateRunner {

    private final SessionFactory sessionFactory;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final StoreRepository storeRepository;

    public HibernateRunner() {
        sessionFactory = SessionCreator.getSessionFactory();
        customerRepository = new CustomerRepository(sessionFactory);
        addressRepository = new AddressRepository(sessionFactory);
        cityRepository = new CityRepository(sessionFactory);
        countryRepository = new CountryRepository(sessionFactory);
        storeRepository = new StoreRepository(sessionFactory);
    }

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();
        System.out.println(hibernateRunner.getCustomer((short) 1));
        Customer customer = new Customer();
        System.out.println(customer.getId());
    }

    private Customer getCustomer(short i) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = customerRepository.get(i);
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
