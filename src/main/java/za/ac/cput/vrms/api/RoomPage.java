package za.ac.cput.vrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.vrms.domain.Room;
import za.ac.cput.vrms.model.RoomResource;
import za.ac.cput.vrms.services.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@RestController
public class RoomPage {
    @Autowired
    private RoomService service;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<RoomResource> getRooms() {
        List<RoomResource> hateos = new ArrayList<>();
        List<Room> rooms = service.findAll();
        for (Room room1 : rooms) {
            RoomResource resource = new RoomResource.Builder(room1.getType())
                    .id(room1.getId())
                    .build();
            Link room = new Link("http://localhost:8080/rooms/" + resource.getRoomId().toString())
                    .withRel("room");
            resource.add(room);
            hateos.add(resource);
        }

        return hateos;
    }
}
