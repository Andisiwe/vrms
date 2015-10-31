package za.ac.cput.vrms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
public class Residence implements Serializable {
    private String id;
    private String name;
    private String town;
    private List<City> city = new ArrayList<>();

    public Residence(){

    }

    public Residence(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.town = builder.town;
        this.city = builder.city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public List<City> getCity() {
        return city;
    }

    public static class Builder {
        private String id;
        private String name;
        private String town;
        private List<City> city = new ArrayList<>();

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder town(String town) {
            this.town = town;
            return this;
        }

        public Builder city(List<City> city) {
            this.city = city;
            return this;
        }

        public Builder copy(Residence residence){
            this.id = residence.id;
            this.name = residence.name;
            this.town = residence.town;
            this.city = residence.city;
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
