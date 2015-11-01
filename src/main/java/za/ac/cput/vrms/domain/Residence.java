package za.ac.cput.vrms.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@Entity
public class Residence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String town;
    @OneToMany
    @JoinColumn(name = "id")
    private List<City> cities;

    public Residence(){

    }

    public Residence(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.town = builder.town;
        this.cities = builder.cities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public List<City> getCity() {
        return cities;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String town;
        private List<City> cities;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder town(String town) {
            this.town = town;
            return this;
        }

        public Builder city(List<City> cities) {
            this.cities = cities;
            return this;
        }

        public Builder copy(Residence residence){
            this.id = residence.id;
            this.name = residence.name;
            this.town = residence.town;
            this.cities = residence.cities;
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
