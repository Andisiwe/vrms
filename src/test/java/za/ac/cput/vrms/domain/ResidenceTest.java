package za.ac.cput.vrms.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.vrms.factories.ResidenceFactory;

/**
 * Created by Andies on 2015-11-01.
 */
public class ResidenceTest {
    @Test
    public void testCreateResidence() throws Exception {

        //List<City> cities = new ArrayList<>();
        Residence residence = ResidenceFactory.createResidence("Plein Residence", "Cape Town"/*, cities*/);

        Assert.assertEquals("Plein Residence", residence.getName());

    }

}
