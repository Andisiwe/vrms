package za.ac.cput.vrms.domain;

import java.io.Serializable;

/**
 * Created by student on 2015/11/04.
 */
public class Assign implements Serializable {

    private Long id;
    private String roomNumber;
    private String studentNumber;
    private Assign(){
    }
    public Assign(Builder builder){
        this.id = builder.id;
        this.roomNumber = builder.roomNumber;
        this.studentNumber = builder.studentNumber;
    }
    public static class Builder{
        private Long id;
        private String roomNumber;
        private String studentNumber;
        public Builder(String roomNumber){
            this.roomNumber = roomNumber;
        }
        public Builder studentNumber(String value){
            this.studentNumber = value;
            return this;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder copy(Assign value){
            this.id = value.id;
            this.roomNumber = value.roomNumber;
            this.studentNumber = value.studentNumber;
            return this;
        }
        public Assign build(){
            return new Assign(this);
        }
    }
    public Long getId(){
        return id;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assign assign = (Assign) o;
        return id.equals(assign.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "Assign{" +
                "roomNumber='" + roomNumber + '\'' +
                ", studentNumber ='" + studentNumber + '\'' +
                '}';
    }
}