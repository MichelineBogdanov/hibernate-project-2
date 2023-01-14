package org.hibernate_project_2.runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate_project_2.entity.City;
import org.hibernate_project_2.entity.Customer;
import org.hibernate_project_2.dao.*;
import org.hibernate_project_2.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateRunner {

    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
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
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public static void main(String[] args) {
        HibernateRunner hibernateRunner = new HibernateRunner();

        Customer customer = hibernateRunner.createCustomer();
        Inventory inventory = hibernateRunner.customerRentInventory(customer, "ACADEMY DINOSAUR");
        hibernateRunner.customerReturnInventory(customer, inventory);
        hibernateRunner.newFilmWasMade();
    }

    private Film newFilmWasMade() {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Language language = languageDAO.getById((byte) 1);
            List<Category> categories = categoryDAO.getAll();
            List<Actor> actors = new ArrayList<>();
            actors.add(actorDAO.getById((short) 1));
            actors.add(actorDAO.getById((short) 2));
            actors.add(actorDAO.getById((short) 3));
            actors.add(actorDAO.getById((short) 4));

            Film film = new Film();
            film.setActors(new HashSet<>(actors));
            film.setRating(Rating.NC17);
            film.setSpecialFeatures(Set.of(SpecialFeatures.TRAILERS, SpecialFeatures.COMMENTARIES));
            film.setLength((short) 75);
            film.setReplacementCost(BigDecimal.valueOf(27.77));
            film.setRentalRate(BigDecimal.valueOf(7.77));
            film.setLanguage(language);
            film.setDescription("New film 2023");
            film.setTitle("Back in time");
            film.setRentalDuration((byte) 3);
            film.setOriginalLanguage(language);
            film.setCategories(new HashSet<>(categories));
            film.setYear(Year.now());
            filmDAO.create(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmText.setDescription("New film 2023");
            filmText.setTitle("Back in time");
            filmTextDAO.create(filmText);

            transaction.commit();
        }
        return null;
    }

    private Inventory customerRentInventory(Customer customer, String title) {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Store store = storeDAO.getById((byte) 1);

            Film film = new Film();
            film.setTitle(title);
            Film foundFilm = filmDAO.findByCriteria(film).get(0);

            Inventory freeInventory = inventoryDAO
                    .getInventoryByFilmIdAndStoreId(foundFilm.getId(), store.getId())
                    .get(0);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(freeInventory);
            rental.setCustomer(customer);
            rental.setStuff(staff);
            rentalDAO.create(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setAmount(foundFilm.getRentalRate());
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.create(payment);

            transaction.commit();
            return freeInventory;
        } catch (Exception e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
            return null;
        }
    }

    private void customerReturnInventory(Customer customer, Inventory inventory) {
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            Transaction transaction = currentSession.beginTransaction();

            Rental rental = rentalDAO.returnInventory(customer.getId(), inventory.getId());
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.create(rental);

            transaction.commit();
        } catch (Exception e) {
            sessionFactory.getCurrentSession().getTransaction().rollback();
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
