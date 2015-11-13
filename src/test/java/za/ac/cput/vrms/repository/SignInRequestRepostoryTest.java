package za.ac.cput.vrms.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.vrms.VarsityresidencemanagementsystemApplication;
import za.ac.cput.vrms.domain.Security;
import za.ac.cput.vrms.domain.SignInRequest;
import za.ac.cput.vrms.factories.SecurityFactory;
import za.ac.cput.vrms.factories.SignInRequestFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yongama on 2015/11/13.
 */
@SpringApplicationConfiguration(classes = VarsityresidencemanagementsystemApplication.class)
@WebAppConfiguration
public class SignInRequestRepostoryTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    SignInRequestRepostory requestRepository;

    @Test
    public void testCreate() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("code","12345");
        value.put("reason","study");
        Security security = SecurityFactory.createSecurity("Ngwenduna", "Yongama");
        Date date = new Date();
        SignInRequest signInRequest = SignInRequestFactory.createSignInRequest(value, null, security, date);
        requestRepository.save(signInRequest);
        id = signInRequest.getID();
        Assert.assertNotNull(id);

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        SignInRequest signInRequest = requestRepository.findOne(id);
        Assert.assertEquals("study", signInRequest.getReasonForVisit());

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
      /*  City city = cityRepository.findOne(id);
        City newCity = CityFactory.createCity("Cape Town", "8000");
        cityRepository.save(newCity);
        Assert.assertEquals("8000", newCity.getCode());*/

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
      /*  City city = cityRepository.findOne(id);
        cityRepository.delete(city);
        City deletedCity = cityRepository.findOne(id);
        Assert.assertNull(deletedCity);*/

    }
}
