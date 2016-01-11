package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.repository.ResidenceRepository;
import za.ac.cput.vrms.services.ResidenceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@Service
public class ResidenceServiceImpl implements ResidenceService{
    @Autowired
    ResidenceRepository repository;

    @Override
    public List<Residence> findAll() {
        List<Residence> residences = new ArrayList<>();

        Iterable<Residence> residenceIterable = repository.findAll();
        for (Residence residence1 : residenceIterable){
            residences.add(residence1);
        }

        return residences;
    }

    @Override
    public Residence findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Residence save(Residence entity) {
        return repository.save(entity);
    }

    @Override
    public Residence update(Residence entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Residence entity) {
        repository.delete(entity);
    }
}
