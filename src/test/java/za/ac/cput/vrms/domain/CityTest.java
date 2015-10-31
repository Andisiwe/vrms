package za.ac.cput.vrms.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.vrms.factories.CityFactory;

/**
 * Created by Andies on 2015-11-01.
 */
public class CityTest {
    @Test
    public void testCreateCity() throws Exception {

        City city = CityFactory.createCity("Cape Town", "8001");

        Assert.assertEquals("Cape Town", city.getName());

    }

}
