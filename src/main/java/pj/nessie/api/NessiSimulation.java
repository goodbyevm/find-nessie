package pj.nessie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pj.nessie.service.NessieService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * API class which contain methods that is exposed to the client via REST.
 */

@RestController
@RequestMapping("api/v1/nessie")
public class NessiSimulation {

    private final NessieService nessieService;

    @Autowired
    public NessiSimulation(NessieService i_nessieService) {
        nessieService = i_nessieService;
    }

    /**
     * Tries to find nessie given a start lake.
     * @param i_startLake the lake to start the search in.
     * @param i_changeLake if lake should be changed.
     * @return {@code NessieSearchResponse} containing information about the Nessie search result.
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public NessieSearchResponse findNessie(@RequestParam(value="StartLake") Integer i_startLake, @RequestParam(value="ChangeLake") Boolean i_changeLake ) {
        return nessieService.findNessie(i_startLake, i_changeLake);
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
