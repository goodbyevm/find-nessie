package pj.nessie.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class manage the generation of the lakes and locates nessie in one of them. Location of nessie is reset after each check.
 */

@Component
public class LakeManager {

    public static final int TOT_NBR_OF_LAKES = 3;
    private final NessieGenerator nessieGenerator;

    @Autowired
    public LakeManager(NessieGenerator i_lakeGenerator) {
        nessieGenerator = i_lakeGenerator;
    }

    public boolean checkLakeForNessie(int i_lakeNbr) {
        boolean l_isNessieFound = false;
        if (nessieGenerator.getNessieLocation() == i_lakeNbr) {
            l_isNessieFound = true;
        }
        nessieGenerator.resetNessieLocation();
        return l_isNessieFound;
    }

    public void checkIfLakeExists(int i_lakeNbr) throws IllegalArgumentException {
        if (i_lakeNbr < 0 || i_lakeNbr > 2) {
            throw new IllegalArgumentException("Lake does not exist. Please choose a lake between 0 and 2");
        }
    }
}
