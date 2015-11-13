package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.SignInRequest;

import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
public interface SignInRequestService {
    List<SignInRequest> getSignInRequestList();

    SignInRequest findById(Long id);

    SignInRequest save(SignInRequest entity);

    SignInRequest update(SignInRequest entity);

    void delete(SignInRequest entity);
}
