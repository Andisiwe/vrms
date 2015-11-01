package za.ac.cput.vrms.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.domain.Room;
import za.ac.cput.vrms.factories.RoomFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class RoomRepositoryTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    RoomRepository roomRepository;

    @Test
    public void testCreate() throws Exception {

        List<Residence> residences = new ArrayList<>();
        Room room = RoomFactory.createRoom("Single"/*, residences*/);
        roomRepository.save(room);
        id = room.getId();
        Assert.assertNotNull(room.getId());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Room room = roomRepository.findOne(id);
        Assert.assertEquals("Single", room.getType());

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Room room = roomRepository.findOne(id);
        List<Residence> residences = new ArrayList<>();
        Room newRoom = RoomFactory.createRoom("Double"/*, residences*/);
        roomRepository.save(newRoom);
        Assert.assertEquals("Double", newRoom.getType());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Room room = roomRepository.findOne(id);
        roomRepository.delete(room);
        Room deletedRoom = roomRepository.findOne(id);
        Assert.assertNull(deletedRoom);

    }
}
