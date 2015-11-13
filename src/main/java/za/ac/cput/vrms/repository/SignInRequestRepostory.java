package za.ac.cput.vrms.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.vrms.domain.SignInRequest;

/**
 * Created by Yongama on 2015/11/13.
 */
public interface SignInRequestRepostory extends CrudRepository<SignInRequest,Long> {
}
