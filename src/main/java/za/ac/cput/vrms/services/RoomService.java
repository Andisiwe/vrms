package za.ac.cput.vrms.services;

import za.ac.cput.vrms.domain.Room;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
public interface RoomService {
    List<Room> findAll();
}
