package com.hitema.mysql.interfaces;

import com.hitema.mysql.entities.Country;

import java.util.List;

public interface CountryDao {
    public List<Country> getAllCountries();
    public Country getCountryById(Long id);
    public void createCountry(Country country);
    public void updateCountry(Country country);
    public void deleteCountry(Country country);
}
