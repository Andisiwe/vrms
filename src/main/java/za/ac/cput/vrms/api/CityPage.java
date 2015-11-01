package za.ac.cput.vrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.vrms.domain.City;
import za.ac.cput.vrms.model.CityResource;
import za.ac.cput.vrms.services.CityService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@RestController
public class CityPage {
    @Autowired
    private CityService service;

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public List<CityResource> getCities() {
        List<CityResource> hateos = new ArrayList<>();
        List<City> cities = service.findAll();
        for(City city1: cities) {
            CityResource resource = new CityResource.Builder(city1.getName())
                    .code(city1.getCode())
                    .id(city1.getId())
                    .build();
            Link c = new Link("http://localhost:8080/cities/" + resource.getCityId().toString())
                    .withRel("city");
            resource.add(c);
            hateos.add(resource);
        }

        return hateos;
    }

}
