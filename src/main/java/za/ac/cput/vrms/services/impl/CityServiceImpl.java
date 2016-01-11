package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.repository.CityRepository;
import za.ac.cput.vrms.services.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository repository;

    @Override
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();

        Iterable<City> cityIterable = repository.findAll();
        for (City city1 : cityIterable){
            cities.add(city1);
        }

        return cities;
    }

    @Override
    public City findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public City save(City entity) {
        return repository.save(entity);
    }

    @Override
    public City update(City entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(City entity) {
        repository.delete(entity);
    }
}
