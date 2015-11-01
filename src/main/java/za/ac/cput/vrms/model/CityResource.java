package za.ac.cput.vrms.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-11-01.
 */
public class CityResource extends ResourceSupport {
    private Long city_id;
    private String code;
    private String name;

    public CityResource(){

    }

    public CityResource(Builder builder){
        this.city_id = builder.city_id;
        this.code = builder.code;
        this.name = builder.name;
    }

    public Long getCityId(){ return city_id;}

    public String getCode(){ return code;}

    public String getName(){ return name;}

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

        public CityResource build(){ return new CityResource(this);}
    }
}
