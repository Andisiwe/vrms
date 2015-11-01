package za.ac.cput.vrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vrms.domain.Residence;

/**
 * Created by Andies on 2015-11-01.
 */
public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
