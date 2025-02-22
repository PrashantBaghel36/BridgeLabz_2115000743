public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
        System.out.println("Database connected.");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return connected;
    }
}
import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
public class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected());
    }

    @Test
    void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected());
    }
}

