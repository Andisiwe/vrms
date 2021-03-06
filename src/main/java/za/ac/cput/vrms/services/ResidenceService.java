package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.Residence;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
public interface ResidenceService {
    List<Residence> findAll();

    Residence findById(Long id);

    Residence save(Residence entity);

    Residence update(Residence entity);

    void delete(Residence entity);
}
