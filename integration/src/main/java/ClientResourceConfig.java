import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Client resource config
 */
public class ClientResourceConfig {

    /**
     * Client.
     */
    protected Client client;

    /**
     * Rest client.
     */
    protected WebTarget webTarget;

    /**
     * Client resource configuration.
     */
    public ClientResourceConfig() {

        client = ClientBuilder.newClient();
        webTarget = client.target(IntegrationConstants.DEFAULT_URL);

    }

    /**
     * Updates web target url.
     *
     * @param resourceUrl
     *         Resource url.
     */
    protected void updateWebTarget(final String resourceUrl) {
        webTarget = client.target(resourceUrl);
    }
}
