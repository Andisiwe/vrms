package za.ac.cput.vrms.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.vrms.factories.SecurityFactory;
import za.ac.cput.vrms.factories.VisitorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yongama on 2015/11/12.
 */
public class VisitorTest {

    @Test
    public void testCreate() throws Exception {
        Map<String,String> visitorValue = new HashMap<String, String>();
        visitorValue.put("ID_number","910203135085");
        visitorValue.put("fName","Yongama");
        visitorValue.put("lName","Yongama");

        Visitor visitor = VisitorFactory.createVisitor(visitorValue);
        Assert.assertEquals("Yongama", visitor.getFirstName());
    }


    @Test
    public void testUpdate() throws Exception {
        Map<String,String> visitorValue = new HashMap<String, String>();
        visitorValue.put("ID_number","910203135085");
        visitorValue.put("fName","Yongama");
        visitorValue.put("lName","Ngwenduna");

        Visitor visitor = VisitorFactory.createVisitor(visitorValue);
        Visitor newVisitor = new Visitor.Builder("91854475588784").copy(visitor).firstName("Thules").build();
        Assert.assertEquals("Thules", newVisitor.getFirstName());
        Assert.assertEquals("Ngwenduna", newVisitor.getLastName());
        Assert.assertEquals("Yongama", visitor.getFirstName());
    }
}
