package za.ac.cput.vrms.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Residence> residences;

    public Room(){

    }

    public Room(Builder builder){
        this.id = builder.id;
        this.type = builder.type;
        this.residences = builder.residences;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Residence> getResidence() {
        return residences;
    }

    public static class Builder{
        private Long id;
        private String type;
        private List<Residence> residences;

        public Builder(String type){this.type = type;}

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder residence(List<Residence> residences){
            this.residences = residences;
            return this;
        }

        public Room build(){return new Room(this);}
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
