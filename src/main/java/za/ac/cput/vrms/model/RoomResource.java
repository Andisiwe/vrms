package za.ac.cput.vrms.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-11-01.
 */
public class RoomResource extends ResourceSupport {
    private Long room_id;
    private String room_type;
    //private List<Residence> residences;

    public RoomResource(){

    }

    public RoomResource(Builder builder){
        this.room_id = builder.room_id;
        this.room_type = builder.room_type;
        // this.residences = builder.residences;
    }

    public Long getRoomId() {
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

        public RoomResource build(){return new RoomResource(this);}
    }
}
