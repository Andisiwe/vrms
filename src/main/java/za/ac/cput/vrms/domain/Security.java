package za.ac.cput.vrms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Createisgetd by student on 2015/04/17.
 */
@Entity
public class Security implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String lName;
    private String fName;
    private Security(){

    }
    Security(Builder builder){
        ID = builder.ID;
        lName = builder.lName;
        fName = builder.fName;
    }
    public Long getID() {
        return ID;
    }

    public String getLName() {
        return lName;
    }

    public String getFName() {
        return fName;
    }


    public static class Builder{
        private Long ID;
        private String lName;
        private String fName;


        public Builder ID(Long value){
            this.ID = value;
            return this;
        }

        public Builder lName(String value){
            this.lName = value;
            return this;
        }

        public Builder fName(String value){
            this.fName = value;
            return this;
        }

        public Builder copy(Security security){
            this.ID = security.ID;
            this.fName = security.fName;
            this.lName = security.lName;
            return this;
        }
        public Security build(){
            return new Security(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Security security = (Security) o;

        if (ID != null ? !ID.equals(security.ID) : security.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Security{" +
                "ID=" + ID +
                ", LName='" + lName + '\'' +
                '}';
    }
}
