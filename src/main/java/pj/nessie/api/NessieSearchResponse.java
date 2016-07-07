package pj.nessie.api;

/**
 * Wrapper class for the search result.
 */

public class NessieSearchResponse {

    /**
     * {@code true} if Nessie was found and {@code false} if not.
     */
    public final boolean foundNessie;

    public NessieSearchResponse(Boolean i_foundNessie) {
        foundNessie = i_foundNessie;
    }

}
