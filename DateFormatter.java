import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class DateFormatter {
    public static String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}
public class DateFormatterTest {

    @Test
    void testValidDateFormat() throws ParseException {
        assertEquals("31-12-2023", DateFormatter.formatDate("2023-12-31"));
        assertEquals("01-01-2024", DateFormatter.formatDate("2024-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> DateFormatter.formatDate("31-12-2023"));
        assertThrows(ParseException.class, () -> DateFormatter.formatDate("2024/01/01"));
    }
}
