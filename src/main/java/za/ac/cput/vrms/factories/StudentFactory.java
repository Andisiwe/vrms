package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Student;

/**
 * Created by student on 2015/11/05.
 */
public class StudentFactory {

    public static Student createStudent(String studentNumber, String name, String surname, String gender){
        Student student = new Student
                .Builder(studentNumber)
                .name(name)
                .surname(surname)
                .gender(gender)
                .build();
        return student;
    }
}
