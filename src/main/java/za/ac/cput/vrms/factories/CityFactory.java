package za.ac.cput.vrms.factories;

import za.ac.cput.vrms.domain.City;

/**
 * Created by Andies on 2015-11-01.
 */
public class CityFactory {

    public static City createCity(String name, String code){
        City city = new City.Builder(name)
                .code(code)
                .build();
        return city;
    }

}
