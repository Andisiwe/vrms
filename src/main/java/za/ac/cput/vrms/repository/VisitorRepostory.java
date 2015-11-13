package za.ac.cput.vrms.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.vrms.domain.Visitor;

/**
 * Created by Yongama on 2015/11/13.
 */
public interface VisitorRepostory extends CrudRepository<Visitor,Long> {
}
