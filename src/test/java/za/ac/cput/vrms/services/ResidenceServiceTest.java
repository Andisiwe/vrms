package za.ac.cput.vrms.services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.factories.ResidenceFactory;
import za.ac.cput.vrms.repository.ResidenceRepository;

import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class ResidenceServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ResidenceService service;

    private Long id;

    @Autowired
    private ResidenceRepository repository;
    private Residence residence;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {
        Residence residence = ResidenceFactory.createResidence("Plein Residence", "Cape Town");
        repository.save(residence);
        id = residence.getId();
        Assert.assertNotNull(residence.getId());

    }

    @Test
    public void testFindAll() throws Exception {
        List<Residence> residences = service.findAll();
        Assert.assertNotNull(residences);

    }
}
