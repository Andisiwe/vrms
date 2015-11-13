package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.Visitor;

import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
public interface VisitorService {

    List<Visitor> getVisitorsList();

    Visitor findById(Long id);

    Visitor save(Visitor entity);

    Visitor update(Visitor entity);

    void delete(Visitor entity);
}
