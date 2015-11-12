package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Visitor;

import java.util.Map;

/**
 * Created by Yongama on 2015/11/12.
 */
public class VisitorFactory {
    public static Visitor createVisitor(Map<String,String> value){
        return new Visitor.Builder(value.get("ID_number"))
                .firstName(value.get("fName"))
                .lastName(value.get("lName"))
                .build();

    }
}
