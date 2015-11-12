package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Security;

/**
 * Created by Yongama on 2015/11/12.
 */
public class SecurityFactory {
    public static Security createSecurity(String lastName, String firstName){
        return new Security.Builder()
                .fName(firstName)
                .lName(lastName)
                .build();
    }
}
