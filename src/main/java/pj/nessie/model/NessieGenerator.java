package pj.nessie.model;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Generated the location of Nessie.
 */

@Component
public class NessieGenerator {

    public static final int TOT_NBR_OF_LAKES = 3;
    private final Random rand;
    private int nessieLocation;

    public NessieGenerator() {
        rand = new Random();
        nessieLocation = rand.nextInt(TOT_NBR_OF_LAKES);
    }

    /**
     * Retrieves the location of Nessie.
     * @return the index of the lake where Nessie is located. The index is returned as an {@code int} inside the boundaries of 0-2
     */
    public int getNessieLocation() {
        return nessieLocation;
    }

    public void resetNessieLocation() {
        nessieLocation = rand.nextInt(TOT_NBR_OF_LAKES);
    }
}
