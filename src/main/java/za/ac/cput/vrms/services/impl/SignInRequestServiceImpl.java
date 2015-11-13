package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vrms.domain.SignInRequest;
import za.ac.cput.vrms.repository.SignInRequestRepostory;
import za.ac.cput.vrms.services.SignInRequestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yongama on 2015/11/13.
 */
public class SignInRequestServiceImpl implements SignInRequestService {
    @Autowired
    SignInRequestRepostory repostory;
    @Override
    public List<SignInRequest> getSignInRequestList() {

        List<SignInRequest> signInRequestList = new ArrayList<SignInRequest>();
        Iterable<SignInRequest> requests = repostory.findAll();
        for (SignInRequest s : requests){
            signInRequestList.add(s);
        }
        return signInRequestList;
    }

    @Override
    public SignInRequest findById(Long id) {
        return repostory.findOne(id);
    }

    @Override
    public SignInRequest save(SignInRequest entity) {
        return repostory.save(entity);
    }

    @Override
    public SignInRequest update(SignInRequest entity) {
        return repostory.save(entity);
    }

    @Override
    public void delete(SignInRequest entity) {
        repostory.delete(entity);
    }
}
