package com.hitema.mysql.dao;

import com.hitema.mysql.entities.City;
import com.hitema.mysql.entities.Country;
import com.hitema.mysql.interfaces.CityDao;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CityDaoImpl implements CityDao {

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
    public List<City> getAllCityies() {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM City");
        List<City> cities = query.list();
        return cities;
    }

    @Override
    public City getCityById(Long id) {
        Session session = getCurrentSession();
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    @Transactional
    public void createCity(City city) {
        Session session = getCurrentSession();
        session.save(city);
    }

    @Override
    @Transactional
    public void updateCity(City city) {
        Session session = getCurrentSession();
        session.update(city);
    }

    @Override
    @Transactional
    public void deleteCity(City city) {
        Session session = getCurrentSession();
        session.delete(city);
    }
}
