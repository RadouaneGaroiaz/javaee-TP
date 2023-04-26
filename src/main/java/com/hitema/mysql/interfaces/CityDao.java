package com.hitema.mysql.interfaces;

import com.hitema.mysql.entities.City;
import com.hitema.mysql.entities.Country;

import java.util.List;

public interface CityDao {
    public List<City> getAllCityies();
    public City getCityById(Long id);
    public void createCity(City city);
    public void updateCity(City city);
    public void deleteCity(City city);

}
