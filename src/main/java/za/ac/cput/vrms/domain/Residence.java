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
public class Residence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long res_id;
    private String name;
    private String town;
    //@OneToMany
    //@JoinColumn(name = "city_id")
    //private List<City> cities;

    public Residence(){

    }

    public Residence(Builder builder){
        this.res_id = builder.res_id;
        this.name = builder.name;
        this.town = builder.town;
       // this.cities = builder.cities;
    }

    public Long getId() {
        return res_id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

   /* public List<City> getCity() {
        return cities;
    }*/

    public static class Builder {
        private Long res_id;
        private String name;
        private String town;
       // private List<City> cities;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long id) {
            this.res_id = id;
            return this;
        }

        public Builder town(String town) {
            this.town = town;
            return this;
        }

       /* public Builder city(List<City> cities) {
            this.cities = cities;
            return this;
        }*/

        public Builder copy(Residence residence){
            this.res_id = residence.res_id;
            this.name = residence.name;
            this.town = residence.town;
           // this.cities = residence.cities;
            return this;
        }

        public Residence build() {
            return new Residence(this);
        }

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
