package za.ac.cput.vrms.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.vrms.factories.StudentFactory;

/**
 * Created by student on 2015/11/05.
 */
public class StudentTest {

    @Test
    public void testCreate() throws Exception {
        Student student = StudentFactory
                .createStudent("213037041", "Tee", "Math", "Female");
        Assert.assertEquals("213037041", student.getStudentNumber());
    }
    @Test
    public void testUpdate() throws Exception {
        Student student = new Student.Builder("213037041")
                .name("Tee")
                .id(new Long(3))
                .build();
        Student newstudent = new Student
                .Builder(student.getStudentNumber())
                .copy(student)
                .name("Tiego").build();
        Assert.assertEquals("Tiego",newstudent.getName());
        Assert.assertEquals("213037041",newstudent.getStudentNumber());
        Assert.assertEquals("213037041",student.getStudentNumber());
    }
}
