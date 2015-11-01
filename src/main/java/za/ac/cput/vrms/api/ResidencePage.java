package za.ac.cput.vrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.vrms.domain.Residence;
import za.ac.cput.vrms.model.ResidenceResource;
import za.ac.cput.vrms.services.ResidenceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andies on 2015-11-01.
 */
@RestController
public class ResidencePage {
    @Autowired
    private ResidenceService service;

    @RequestMapping(value = "/residences", method = RequestMethod.GET)
    public List<ResidenceResource> getResidences() {
        List<ResidenceResource> hateos = new ArrayList<>();
        List<Residence> residences = service.findAll();
        for (Residence residence1 : residences) {
            ResidenceResource resource = new ResidenceResource.Builder(residence1.getName())
                    .town(residence1.getTown())
                    .id(residence1.getId())
                    .build();
            Link res = new Link("http://localhost:8080/residences/" + resource.getResId().toString())
                    .withRel("res");
            resource.add(res);
            hateos.add(resource);
        }

        return hateos;
    }
}
