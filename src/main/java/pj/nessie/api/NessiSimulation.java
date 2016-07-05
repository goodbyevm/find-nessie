package pj.nessie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pj.nessie.service.NessieService;

/**
 * Service class which contain methods regarding the simulation which will be exposed to the client via REST.
 */

@RestController
public class NessiSimulation {

    private final NessieService nessieService;

    @Autowired
    public NessiSimulation(NessieService i_nessieService) {
        nessieService = i_nessieService;
    }

    @RequestMapping("/name")
    public String getNessieName() {
        return nessieService.getNameOfNessie();
    }
}
