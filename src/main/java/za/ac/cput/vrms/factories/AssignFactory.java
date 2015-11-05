package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Assign;

/**
 * Created by student on 2015/11/05.
 */
public class AssignFactory {
    public static Assign createAssign(String roomNumber, String studentNumber){
        Assign assign = new Assign
                .Builder(roomNumber)
                .studentNumber(studentNumber)
                .build();
        return assign;
    }
}
