package pj.nessie.api;

/**
 * Wrapper class for the search result.
 */

public class NessieSearchResponse {

    public final boolean foundNessie;

    public NessieSearchResponse(Boolean i_foundNessie) {
        foundNessie = i_foundNessie;
    }

}
