package pj.nessie.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pj.nessie.api.NessieSearchResponse;
import pj.nessie.model.FisherMan;
import pj.nessie.model.LakeManager;

import static org.mockito.Mockito.*;

public class TestNessieService {

    private NessieService nessieService;
    private FisherMan fisherMan;
    private LakeManager lakeManager;
    private boolean changeLake = true;


    @Before
    public void setUp() {
        lakeManager = mock(LakeManager.class);
        fisherMan = mock(FisherMan.class);
        nessieService = new NessieService(lakeManager, fisherMan);
    }

    @Test
    public void testToSuccessfullyFindNessie() {
        when(fisherMan.getLakeAdvice(1)).thenReturn(3);
        when(lakeManager.checkLakeForNessie(3)).thenReturn(true);
        NessieSearchResponse nessieResponse = nessieService.findNessie(1, changeLake);
        Assert.assertTrue(nessieResponse.foundNessie);
    }

    @Test
    public void testToUnSuccessfullyFindNessie() {
        when(lakeManager.checkLakeForNessie(1)).thenReturn(false);
        NessieSearchResponse nessieResponse = nessieService.findNessie(1, changeLake);
        Assert.assertFalse(nessieResponse.foundNessie);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testToNonExistingLake() {
        Mockito.doThrow(new IllegalArgumentException()).when(lakeManager).checkIfLakeExists(3);
        Mockito.doThrow(new IllegalArgumentException()).when(lakeManager).checkIfLakeExists(-1);
        nessieService.findNessie(3, changeLake);
        nessieService.findNessie(-1, changeLake);
    }

    @Test (expected = NullPointerException.class)
    public void testNullAsInparameter(){
        nessieService.findNessie(null, null);
    }
}
