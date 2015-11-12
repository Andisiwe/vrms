package za.ac.cput.vrms.domain;


import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
public class Visitor implements Serializable {
    private Long id;

    private String ID_number;

    private String firstName;
    private String lastName;

    private Visitor(){}
    public Visitor(Builder builder){
        this.id = builder.id;
        ID_number = builder.ID_number;
        firstName = builder.firstName;
        lastName = builder.lastName;
    }


    public Long getId() {
        return id;
    }

    public String getID_number() {
        return ID_number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public static class Builder{
        private Long id;
        private String ID_number;
        private String firstName;
        private String lastName;

        public Builder(String value){
            this.ID_number = value;
        }

        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }



        public Builder copy(Visitor value){
            this.ID_number = value.ID_number;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.id = value.id;
            return this;
        }

        public Visitor build(){
            return new Visitor(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        return !(id != null ? !id.equals(visitor.id) : visitor.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
