package pj.nessie.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestFisherMan {

    public static final int NESSIE_LOCATION = 2;
    FisherMan fisherMan;
    NessieGenerator nessieGenerator;

    @Before
    public void setUp() {
        nessieGenerator = mock(NessieGenerator.class);
        fisherMan = new FisherMan(nessieGenerator);
    }

    @Test
    public void testAdviceLocatingNessie() {
        when(nessieGenerator.getNessieLocation()).thenReturn(NESSIE_LOCATION);
        int l_advice = fisherMan.getLakeAdvice(1);
        assertTrue(2 == l_advice);
    }

    @Test
    public void testAdviceLocatingEmpty() {
        when(nessieGenerator.getNessieLocation()).thenReturn(NESSIE_LOCATION);
        int l_advice = fisherMan.getLakeAdvice(2);
        assertTrue(l_advice == 0 || l_advice == 1);
    }

}
