package pj.nessie.service;

import org.springframework.stereotype.Service;
import pj.nessie.model.Nessie;

/**
 * TODO: Write JavaDoc for this class
 */

@Service
public class NessieService {

    private final Nessie l_nessi;

    public NessieService() {
        l_nessi = new Nessie();
    }

    public String getNameOfNessie() {
        return l_nessi.getNessieName();
    }

}
