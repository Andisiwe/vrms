package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.Security;

import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
public interface SecurityService {
    List<Security> getSecurityList();

    Security findById(Long id);

    Security save(Security entity);

    Security update(Security entity);

    void delete(Security entity);
}
