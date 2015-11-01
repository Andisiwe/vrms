package za.ac.cput.vrms.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.factories.ResidenceFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class ResidenceRepositoryTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    ResidenceRepository residenceRepository;

    @Test
    public void testCreate() throws Exception {

        List<City> cities = new ArrayList<>();
        Residence residence = ResidenceFactory.createResidence("Plein Residence", "Cape Town"/*, cities*/);
        residenceRepository.save(residence);
        id = residence.getId();
        Assert.assertNotNull(residence.getId());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Residence residence = residenceRepository.findOne(id);
        Assert.assertEquals("Plein Residence", residence.getName());

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Residence residence = residenceRepository.findOne(id);
        List<City> cities = new ArrayList<>();
        Residence newResidence = ResidenceFactory.createResidence("NMJ","Cape Town"/*, cities*/);
        residenceRepository.save(newResidence);
        Assert.assertEquals("NMJ", newResidence.getName());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Residence residence = residenceRepository.findOne(id);
        residenceRepository.delete(residence);
        Residence deletedResidence = residenceRepository.findOne(id);
        Assert.assertNull(deletedResidence);

    }
}
