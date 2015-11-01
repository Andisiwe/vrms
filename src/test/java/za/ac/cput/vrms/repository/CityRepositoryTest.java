package za.ac.cput.vrms.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.factories.CityFactory;


/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class CityRepositoryTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    CityRepository cityRepository;

    @Test
    public void testCreate() throws Exception {

        City city = CityFactory.createCity("Cape Town", "8001");
        cityRepository.save(city);
        id = city.getId();
        Assert.assertNotNull(city.getId());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        City city = cityRepository.findOne(id);
        Assert.assertEquals("Cape Town", city.getName());

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        City city = cityRepository.findOne(id);
        City newCity = CityFactory.createCity("Cape Town", "8000");
        cityRepository.save(newCity);
        Assert.assertEquals("8000", newCity.getCode());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        City city = cityRepository.findOne(id);
        cityRepository.delete(city);
        City deletedCity = cityRepository.findOne(id);
        Assert.assertNull(deletedCity);

    }
}
