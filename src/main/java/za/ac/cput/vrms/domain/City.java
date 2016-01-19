package za.ac.cput.vrms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by Andies on 2015-10-31.
 */
@Entity
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long city_id;
    private String code;
    private String name;

    public City(){

    }

    public City(Builder builder){
        this.city_id = builder.city_id;
        this.code = builder.code;
        this.name = builder.name;
    }

    public Long getId(){ return city_id;}

    public String getCode(){ return code;}

    public String getName(){ return name;}

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        private Long city_id;
        private String code;
        private String name;

        public Builder(String name){this.name = name;}

        public Builder id(Long id){
            this.city_id = id;
            return this;
        }

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder copy(City value){
            this.city_id = value.city_id;
            this.name = value.name;
            this.code = value.code;
            return this;
        }


        public City build(){ return new City(this);}
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
