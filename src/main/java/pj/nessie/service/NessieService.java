package pj.nessie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pj.nessie.api.NessieSearchResponse;
import pj.nessie.model.FisherMan;
import pj.nessie.model.LakeManager;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class NessieService {

    private final LakeManager lakeManager;
    private final FisherMan fisherMan;

    @Autowired
    public NessieService(LakeManager i_lakeManager, FisherMan i_fisherMan) {
        lakeManager = i_lakeManager;
        fisherMan = i_fisherMan;
    }

    /**
     * This method tries to locate nessie in one of the lakes.
     * @param i_startLake what lake to start look in.
     * @return {@code NessieSearchResponse} containing information about if nessie was found or not.
     */
    public NessieSearchResponse findNessie(Integer i_startLake, Boolean i_changeLake) throws IllegalArgumentException {
        int l_lakeToVisit = i_startLake;
        lakeManager.checkIfLakeExists(l_lakeToVisit);
        if (i_changeLake) {
            l_lakeToVisit = fisherMan.getLakeAdvice(i_startLake);
        }
        return new NessieSearchResponse(lakeManager.checkLakeForNessie(l_lakeToVisit));
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
