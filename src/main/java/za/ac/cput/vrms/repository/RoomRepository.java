package za.ac.cput.vrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vrms.domain.Room;

/**
 * Created by Andies on 2015-11-01.
 */
public interface RoomRepository extends JpaRepository<Room, Long> {
}
