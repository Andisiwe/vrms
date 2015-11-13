package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Security;
import za.ac.cput.vrms.domain.SignInRequest;
import za.ac.cput.vrms.domain.Visitor;

import java.util.Date;
import java.util.Map;

/**
 * Created by Yongama on 2015/11/12.
 */
public class SignInRequestFactory {
    public static SignInRequest createSignInRequest(Map<String,String> value,
                                                    Visitor visitor,
                                                    Security security,
                                                    Date visitDate){
        SignInRequest signInRequest = new SignInRequest
                .Builder()
                .visitor(visitor)
                .security(security)
                .visitDate(visitDate)
                .reasonForVisit(value.get("reason"))
                .visit_code(value.get("code"))
                .build();
        return signInRequest;
    }
}
