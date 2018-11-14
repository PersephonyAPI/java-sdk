package world;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.configuration.ConfigurationProperties.overrideLogLevel;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class Helper {

    private static int SERVERPORT = 9005;
    private static ClientAndServer mockServer;

    @Before("@Mockserver")
    public static void setupMockAPIServer() {
        overrideLogLevel("WARN");
        if(mockServer != null) {
            mockServer.stop();
        }
        mockServer = startClientAndServer(SERVERPORT);
    }

    @After("@Mockserver")
    public static void cleanupMockServer(){
        mockServer.stop();
    }

    public static ClientAndServer getMockServer() {
        return mockServer;
    }

    public static int getServerPort() {
        return SERVERPORT;
    }
}
