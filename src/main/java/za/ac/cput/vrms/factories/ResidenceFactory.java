package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.Residence;

/**
 * Created by Andies on 2015-11-01.
 */
public class ResidenceFactory {


    public static Residence createResidence(String name, String town/*, List<City> cities*/){
        Residence residence = new Residence.Builder(name)
                .town(town)
                //.city(cities)
                .build();
        return residence;
    }

}
