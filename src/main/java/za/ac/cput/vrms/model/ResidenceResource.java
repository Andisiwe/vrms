package za.ac.cput.vrms.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-11-01.
 */
public class ResidenceResource extends ResourceSupport {
    private Long res_id;
    private String name;
    private String town;
    //private List<City> cities;

    public ResidenceResource(){

    }

    public ResidenceResource(Builder builder){
        this.res_id = builder.res_id;
        this.name = builder.name;
        this.town = builder.town;
        // this.cities = builder.cities;
    }

    public Long getResId() {
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

        public Builder copy(ResidenceResource residence){
            this.res_id = residence.res_id;
            this.name = residence.name;
            this.town = residence.town;
            // this.cities = residence.cities;
            return this;
        }

        public ResidenceResource build() {
            return new ResidenceResource(this);
        }

    }
}
