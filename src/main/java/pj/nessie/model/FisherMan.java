package pj.nessie.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Class to that represents a fisherman. The fisherman gives the client advice on what lake to search for Nessie in.
 */

@Component
public class FisherMan {

    private final NessieGenerator nessieGenerator;

    @Autowired
    public FisherMan(NessieGenerator i_nessieGenerator) {
        nessieGenerator = i_nessieGenerator;
    }

    /**
     * Calculates a new lake advice where Nessie potentially could be located.
     * @param i_lakeNbr    intended lake to visit
     * @return  number of the lake to visit based.
     */
    public int getLakeAdvice(int i_lakeNbr) {
        Random rand = new Random();
        int l_lakeAdvice = rand.nextInt(LakeManager.TOT_NBR_OF_LAKES);
            int l_emptyLake = rand.nextInt(LakeManager.TOT_NBR_OF_LAKES);
            //Find empty lake
            int nessieLocation = nessieGenerator.getNessieLocation();
            while (l_emptyLake == i_lakeNbr || l_emptyLake == nessieLocation) {
                l_emptyLake = rand.nextInt(LakeManager.TOT_NBR_OF_LAKES);
            }
            //Find the lake that will result in an new advice.
            while (l_lakeAdvice == l_emptyLake || l_lakeAdvice == i_lakeNbr) {
                l_lakeAdvice = rand.nextInt(LakeManager.TOT_NBR_OF_LAKES);
            }
        return l_lakeAdvice;
    }
}
