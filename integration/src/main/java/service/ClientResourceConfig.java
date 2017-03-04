package service;


import constants.IntegrationConstants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

/**
 * Client resource config
 */
public class ClientResourceConfig {

    /**
     * Rest client.
     */
    protected WebTarget webTarget;

    /**
     * Client resource configuration.
     */
    public ClientResourceConfig(){

        final Client client = ClientBuilder.newClient();
        webTarget = client.target(IntegrationConstants.resourceUrl);

    }
}
