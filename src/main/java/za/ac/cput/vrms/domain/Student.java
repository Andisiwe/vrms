package za.ac.cput.vrms.domain;

import java.io.Serializable;

/**
 * Created by student on 2015/11/04.
 */
public class Student implements Serializable{

    private Long id;
    private String studentNumber;
    private String name;
    private String surname;
    private String gender;
    private Student(){
    }
    public Student(Builder builder){
        this.id = builder.id;
        this.studentNumber = builder.studentNumber;
        this.name = builder.name;
        this.surname = builder.surname;
        this.gender = builder.gender;
    }
    public static class Builder {
        private Long id;
        private String studentNumber;
        private String name;
        private String surname;
        private String gender;
        public Builder(String studentNumber) {
            this.studentNumber = studentNumber;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder surname(String value) {
            this.surname = value;
            return this;
        }
        public Builder gender(String value) {
            this.gender = value;
            return this;
        }
        public Builder id(Long value) {
            this.id = value;
            return this;
        }
        public Builder copy(Student value) {
            this.id = value.id;
            this.studentNumber = value.studentNumber;
            this.name = value.name;
            this.surname = value.surname;
            this.gender = value.gender;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
    public Long getId(){
        return id;
    }
    public String getStudentNumber(){
        return studentNumber;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getGender(){
        return gender;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", gender ='" + gender + '\'' +
                '}';
    }
}
