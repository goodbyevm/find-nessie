package pj.nessie.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manage the lake search for Nessie.
 */

@Component
public class LakeManager {

    public static final int TOT_NBR_OF_LAKES = 3;
    private final NessieGenerator nessieGenerator;

    @Autowired
    public LakeManager(NessieGenerator i_lakeGenerator) {
        nessieGenerator = i_lakeGenerator;
    }

    /**
     * Checks a given lake for Nessie.
     * @param i_lakeNbr the number of the lake
     * @return {@code true} if found and {@code false} if not
     */
    public boolean checkLakeForNessie(int i_lakeNbr) {
        boolean l_isNessieFound = false;
        if (nessieGenerator.getNessieLocation() == i_lakeNbr) {
            l_isNessieFound = true;
        }
        nessieGenerator.resetNessieLocation();
        return l_isNessieFound;
    }

    /**
     * Check that the lake number is not out of bound.
     * @param i_lakeNbr the lake number to check for
     * @throws IllegalArgumentException if the lake does not exist.
     */
    public void checkIfLakeExists(int i_lakeNbr) throws IllegalArgumentException {
        if (i_lakeNbr < 0 || i_lakeNbr > 2) {
            throw new IllegalArgumentException("Lake does not exist. Please choose a lake between 0 and 2");
        }
    }
}
