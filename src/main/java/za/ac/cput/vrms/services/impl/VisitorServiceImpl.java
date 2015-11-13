package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vrms.domain.Visitor;
import za.ac.cput.vrms.repository.VisitorRepostory;
import za.ac.cput.vrms.services.VisitorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorRepostory repostory;

    @Override
    public List<Visitor> getVisitorsList() {
        List<Visitor> visitorList = new ArrayList<Visitor>();
        Iterable<Visitor> visitors = repostory.findAll();
        for (Visitor v : visitors){
            visitorList.add(v);
        }
        return visitorList;
    }

    @Override
    public Visitor findById(Long id) {
        return repostory.findOne(id);
    }

    @Override
    public Visitor save(Visitor entity) {
        return repostory.save(entity);
    }

    @Override
    public Visitor update(Visitor entity) {
        return repostory.save(entity);
    }

    @Override
    public void delete(Visitor entity) {
        repostory.delete(entity);
    }
}
