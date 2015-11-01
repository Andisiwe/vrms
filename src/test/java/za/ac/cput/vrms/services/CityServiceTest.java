package za.ac.cput.vrms.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.factories.CityFactory;
import za.ac.cput.vrms.repository.CityRepository;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class CityServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CityService service;

    private Long id;

    @Autowired
    private CityRepository repository;
    private City city;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {
        City city = CityFactory.createCity("Cape Town","8001");
        repository.save(city);
        id = city.getId();
        Assert.assertNotNull(city.getId());

    }

    @Test
    public void testFindAll() throws Exception {
        List<City> citiss = service.findAll();
        Assert.assertNotNull(citiss);

    }

}
