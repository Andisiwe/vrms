package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.domain.Room;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
public class RoomFactory {

    public static Room createRoom(String roomType, List<Residence> residences){
        Room room = new Room.Builder(roomType)
                .residence(residences)
                .build();
        return room;
    }

}
