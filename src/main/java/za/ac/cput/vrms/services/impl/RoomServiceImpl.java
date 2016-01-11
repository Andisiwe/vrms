package za.ac.cput.vrms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vrms.domain.Room;
import za.ac.cput.vrms.repository.RoomRepository;
import za.ac.cput.vrms.services.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomRepository repository;

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();

        Iterable<Room> roomIterable = repository.findAll();
        for (Room room1 : roomIterable){
            rooms.add(room1);
        }

        return rooms;
    }

    @Override
    public Room findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Room save(Room entity) {
        return repository.save(entity);
    }

    @Override
    public Room update(Room entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Room entity) {
        repository.delete(entity);
    }
}
