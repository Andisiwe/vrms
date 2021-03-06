package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.City;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
public interface CityService {
    List<City> findAll();

    City findById(Long id);

    City save(City entity);

    City update(City entity);

    void delete(City entity);
}
