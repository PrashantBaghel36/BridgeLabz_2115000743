import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
public class PerformanceUtils {
    public static String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulate long-running task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}
public class PerformanceUtilsTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTaskTimeout() {
        PerformanceUtils.longRunningTask();
    }
}

