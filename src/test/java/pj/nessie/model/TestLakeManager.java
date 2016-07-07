package pj.nessie.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLakeManager {

    LakeManager lakeManager;
    NessieGenerator nessieGenerator;

    @Before
    public void setUp() {
        nessieGenerator = mock(NessieGenerator.class);
        lakeManager = new LakeManager(nessieGenerator);
    }

    @Test
    public void testToFindNessie() {
        when(nessieGenerator.getNessieLocation()).thenReturn(0);
        assertTrue(lakeManager.checkLakeForNessie(0));
    }

    @Test
    public void testToNotFindNessie() {
        when(nessieGenerator.getNessieLocation()).thenReturn(1);
        assertFalse(lakeManager.checkLakeForNessie(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIfLakeExists() {
        lakeManager.checkIfLakeExists(-1);
    }

}
