package za.ac.cput.vrms.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.vrms.factories.SecurityFactory;
import za.ac.cput.vrms.factories.SignInRequestFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yongama on 2015/11/12.
 */
public class SignInRequestTest {
    @Test
    public void testCreate() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("code","12345");
        value.put("reason","study");
        Security security = SecurityFactory.createSecurity("Ngwenduna", "Yongama");
        Date date = new Date();
        SignInRequest signInRequest = SignInRequestFactory.createSignInRequest(value,null,security,date);
        Assert.assertEquals("study", signInRequest.getReasonForVisit());
    }


    @Test
    public void testUpdate() throws Exception {
        Map<String,String> value = new HashMap<String, String>();
        value.put("code","12345");
        value.put("reason", "study");
        Security security = SecurityFactory.createSecurity("Siswana", "Xoliseka");
        Visitor visitor = new Visitor.Builder("112").build();
        Date date = new Date();
        SignInRequest signInRequest = SignInRequestFactory.createSignInRequest(value,null,security,date);
        SignInRequest newsignInRequest = new SignInRequest.Builder().visitor(null).security(security).copy(signInRequest).visitor(visitor).build();

        Assert.assertNull(signInRequest.getVisitor());
        Assert.assertNotNull(newsignInRequest.getVisitor());


    }

}
