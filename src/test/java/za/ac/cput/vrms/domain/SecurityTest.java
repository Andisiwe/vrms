package za.ac.cput.vrms.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.vrms.factories.SecurityFactory;

/**
 * Created by Yongama on 2015/11/12.
 */
public class SecurityTest {
    @Test
    public void testCreate() throws Exception {
        Security security = SecurityFactory.createSecurity("Ngwenduna", "Yongama");
        Assert.assertEquals("Yongama", security.getFName());
    }


    @Test
    public void testUpdate() throws Exception {
        Security security = SecurityFactory.createSecurity("Ngwenduna", "Yongama");
        Security newSecurity = new Security.Builder().copy(security).fName("Thules").build();
        Assert.assertEquals("Thules", newSecurity.getFName());
        Assert.assertEquals("Ngwenduna", newSecurity.getLName());
        Assert.assertEquals("Yongama", security.getFName());
    }
}
