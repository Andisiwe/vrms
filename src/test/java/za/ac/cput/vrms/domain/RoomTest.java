package za.ac.cput.vrms.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.vrms.factories.RoomFactory;

/**
 * Created by Andies on 2015-11-01.
 */
public class RoomTest {

    @Test
    public void testCreateResidence() throws Exception {

       // List<Residence> residences = new ArrayList<>();
        Room room= RoomFactory.createRoom("Single"/*, residences*/);

        Assert.assertEquals("Single", room.getType());

    }
}
