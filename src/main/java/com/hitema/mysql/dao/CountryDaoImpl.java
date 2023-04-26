package com.hitema.mysql.dao;

import com.hitema.mysql.entities.Country;
import com.hitema.mysql.interfaces.CountryDao;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;



public class CountryDaoImpl implements CountryDao {

    private SessionFactory sessionFactory;
    static Session currentSession;

    public static Session getCurrentSession() {
        if ( ! ( currentSession != null && currentSession.isOpen()))
            currentSession=openCurrentSession();
        return currentSession;
    }

    public static Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    private static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration().configure();
        return cfg.buildSessionFactory();
    }



    @Override
    public List<Country> getAllCountries() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Country");
        List<Country> countries = query.list();
        return countries;
    }

    @Override
    public Country getCountryById(Long id) {
        Session session = getCurrentSession();
        Country country = session.get(Country.class, id);
        return country;
    }

    @Override
    @Transactional
    public void createCountry(Country country) {
        Session session = getCurrentSession();
        session.save(country);
    }

    @Override
    @Transactional
    public void updateCountry(Country country) {
        Session session = getCurrentSession();
        session.update(country);
    }

    @Override
    @Transactional
    public void deleteCountry(Country country) {
        Session session = getCurrentSession();
        session.delete(country);
    }
}
