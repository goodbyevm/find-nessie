package pj.nessie.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestNessieGenerator {

    NessieGenerator lakeGenerator;

    @Before
    public void setUp() {
        lakeGenerator = new NessieGenerator();
    }

    @Test
    public void testBoundaries(){
        for (int i = 10; i>=0; i--) {
            int nessieLocation = lakeGenerator.getNessieLocation();
            assertTrue(nessieLocation >= 0 && nessieLocation <= 2);
        }
    }
}
