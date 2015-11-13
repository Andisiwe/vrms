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
import za.ac.cput.vrms.domain.Visitor;
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
        Security security = SecurityFactory.createSecurity("Hadebe", "Thulebona");
        Date date = new Date();
        SignInRequest signInRequest = SignInRequestFactory.createSignInRequest(value, null, security, date);
        requestRepository.save(signInRequest);
        id = signInRequest.getID();
        Assert.assertNotNull(id);
        Assert.assertNotNull(signInRequest.getSecurity());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        SignInRequest signInRequest = requestRepository.findOne(id);
        Security security = signInRequest.getSecurity();
        Assert.assertEquals("study", signInRequest.getReasonForVisit());
        Assert.assertEquals("Thulebona",security.getFName());

    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        SignInRequest signInRequest = requestRepository.findOne(id);
        Visitor visitor = new Visitor.Builder("112").firstName("Chuleza").lastName("mlonyeni").build();
        SignInRequest newRequest = new SignInRequest.Builder()
                .copy(signInRequest)
                .visitor(visitor)
                .visit_code("1123").build();
        requestRepository.save(newRequest);

        Assert.assertNull(signInRequest.getVisitor());
        Assert.assertNotNull(newRequest.getVisitor());
        Assert.assertTrue(newRequest.getVisit_code().equalsIgnoreCase("1123"));
        Assert.assertTrue(signInRequest.getVisit_code().equals("12345"));

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        SignInRequest signInRequest = requestRepository.findOne(id);
        requestRepository.delete(signInRequest);
        SignInRequest inRequest = requestRepository.findOne(id);
        Assert.assertNull(inRequest);
    }
}
