package org.hibernate_project_2.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate_project_2.entity.City;
import org.hibernate_project_2.entity.Customer;
import org.hibernate_project_2.dao.*;
import org.hibernate_project_2.entity.*;

import java.util.List;

public class HibernateRunner {

    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public HibernateRunner() {
        sessionFactory = SessionCreator.getSessionFactory();
        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();

        hibernateRunner.createCustomer();

        /*try (Session session = hibernateRunner.sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setFirstName("BARBARA");
            customer.setLastName("JONES");
            List<Customer> byCriteria = hibernateRunner.customerDAO.findByCriteria(customer);
            System.out.println(byCriteria.get(0));
            transaction.commit();
        }*/

        /*try (Session session = hibernateRunner.sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            List<Store> all = hibernateRunner.storeDAO.getAll();
            for (Store store : all) {
                System.out.println(store);
            }
            transaction.commit();
        }*/

    }



    private Customer getCustomer(short i) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = customerDAO.getById(i);
            transaction.commit();
            return customer;
        }
    }

    private void customerReturnInventory() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

        }
    }

    private Customer createCustomer() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();
            Customer customer = new Customer();

            String email = "test@test.org";
            customer.setEmail(email);
            if (customerDAO.findByCriteria(customer).isEmpty()) {
                Store store = storeDAO.getById((byte) 1);

                City cityCheck = new City();
                cityCheck.setCity("Aden");
                City city = cityDAO.findByCriteria(cityCheck).get(0);

                Address address = new Address();
                address.setAddress("42 Moscow St");
                address.setDistrict("Moscow City");
                if (addressDAO.findByCriteria(address).isEmpty()) {
                    address.setPhone("1111111111");
                    address.setCity(city);
                    addressDAO.create(address);
                } else {
                    address = addressDAO.findByCriteria(address).get(0);
                }

                customer.setActive(true);
                customer.setAddress(address);
                customer.setStore(store);
                customer.setFirstName("Nastya");
                customer.setLastName("Nastya");
                customerDAO.create(customer);

                transaction.commit();

                return customer;

            } else {
                transaction.rollback();
                return null;
            }
        }
    }
}
