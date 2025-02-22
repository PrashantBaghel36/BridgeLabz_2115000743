import java.util.List;
public class ListManager {

    // Method to add an element to a list
    public static void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    // Method to remove an element from a list
    public static void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element));
        }
    }

    // Method to get the size of the list
    public static int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}
import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
public class ListManagerTest {

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, list.size());
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        ListManager.removeElement(list, 5);
        assertFalse(list.contains(5));
        assertEquals(0, list.size());
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list));
        list.add(10);
        assertEquals(1, ListManager.getSize(list));
    }
}

