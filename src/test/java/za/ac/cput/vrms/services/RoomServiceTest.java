package za.ac.cput.vrms.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.Room;
import za.ac.cput.vrms.factories.RoomFactory;
import za.ac.cput.vrms.repository.RoomRepository;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class RoomServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private RoomService service;

    private Long id;

    @Autowired
    private RoomRepository repository;
    private Room room;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {
        Room room = RoomFactory.createRoom("Single");
        repository.save(room);
        id = room.getId();
        Assert.assertNotNull(room.getId());

    }

    @Test
    public void testFindAll() throws Exception {
        List<Room> rooms = service.findAll();
        Assert.assertNotNull(rooms);

    }
}
