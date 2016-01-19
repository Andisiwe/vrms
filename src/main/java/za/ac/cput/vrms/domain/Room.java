package za.ac.cput.vrms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Andies on 2015-11-01.
 */
@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long room_id;
    private String room_type;
   // @OneToMany
    //@JoinColumn(name = "res_id")
    //private List<Residence> residences;

    public Room(){

    }

    public Room(Builder builder){
        this.room_id = builder.room_id;
        this.room_type = builder.room_type;
       // this.residences = builder.residences;
    }

    public Long getId() {
        return room_id;
    }

    public String getType() {
        return room_type;
    }

    /*public List<Residence> getResidence() {
        return residences;
    }*/

    public static class Builder{
        private Long room_id;
        private String room_type;
       // private List<Residence> residences;

        public Builder(String type){this.room_type = type;}

        public Builder id(Long id){
            this.room_id = id;
            return this;
        }

       /* public Builder residence(List<Residence> residences){
            this.residences = residences;
            return this;
        }*/

        public Builder copy(Room value){
            this.room_id = value.room_id;
            this.room_type = value.room_type;
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
