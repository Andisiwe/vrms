package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vrms.domain.Security;
import za.ac.cput.vrms.repository.SecurityRepostory;
import za.ac.cput.vrms.services.SecurityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    SecurityRepostory repostory;
    @Override
    public List<Security> getSecurityList() {
        List<Security> securityList = new ArrayList<Security>();
        Iterable<Security> securities = repostory.findAll();
        for (Security security : securities){
            securityList.add(security);
        }
        return securityList;
    }

    @Override
    public Security findById(Long id) {
        return repostory.findOne(id);
    }

    @Override
    public Security save(Security entity) {
        return repostory.save(entity);
    }

    @Override
    public Security update(Security entity) {
        return repostory.save(entity);
    }

    @Override
    public void delete(Security entity) {
        repostory.delete(entity);

    }
}
