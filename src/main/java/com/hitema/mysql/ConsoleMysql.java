package com.hitema.mysql;

import com.hitema.mysql.dao.CityDaoImpl;
import com.hitema.mysql.dao.CountryDaoImpl;
import com.hitema.mysql.entities.City;
import com.hitema.mysql.entities.Country;
import com.hitema.mysql.interfaces.CityDao;
import com.hitema.mysql.interfaces.CountryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class ConsoleMysql {

    static Session currentSession;
    public static void main(String[] args) {
        System.out.println("<<<<<Start Console MySql>>>>>");
        try (var session = openCurrentSession()) {
            if (session == null) {
                System.err.println("Erreur ouverture de Session");
                System.exit((-1));
            }
        }


        //instanciation des DAO
        CountryDao countryDao = new CountryDaoImpl();
        CityDao cityDao = new CityDaoImpl();

        //affichage des pays
        countryDao.getAllCountries().forEach(System.out::println);

        //ajout d'un pays
        Country country2 = new Country("Maroc4", LocalDateTime.now());
        countryDao.createCountry(country2);
        System.out.println("Country created : " + country2);

        //get country by id
        countryDao.getCountryById(55L);
        System.out.println("Country with id 55 : " + countryDao.getCountryById(55L));

        //update country
        country2.setId(150L);
        countryDao.updateCountry(country2);
        System.out.println("Country updated : " + country2);

     /*   //delete country
        countryDao.deleteCountry(country2);
        System.out.println("Country deleted : " + country2);*/

        //affichage des villes
        cityDao.getAllCityies().forEach(System.out::println);

        //get city by id
        cityDao.getCityById(1L);
        System.out.println("City with id 1 : " + cityDao.getCityById(1L));

        //ajout d'une ville
        City city1 = new City("Agadir", LocalDateTime.now());
        Country country0 = countryDao.getCountryById(1L);
        city1.setCountry(country0);
        cityDao.createCity(city1);
        System.out.println("City created : " + city1);

        //update city
        City city2 = new City("Berkane2", LocalDateTime.now());
        Country country1 = countryDao.getCountryById(4L);
        //city2.setId(1L);
        cityDao.updateCity(city2);
        System.out.println("City updated : " + city2);

     /*   //delete city
        cityDao.deleteCity(city2);
        System.out.println("City deleted : " + city2);*/



        System.out.println("<<<<<End   Console MySql>>>>>");
    }



    public static Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    private static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration().configure();
        return cfg.buildSessionFactory();
    }



}