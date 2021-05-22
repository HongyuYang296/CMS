import java.time.LocalDate;//use the package
import java.time.format.DateTimeFormatter; //use the package
/**
 *This class is a tool class convert and validate time format
 *
 * @author team56
 * @version 2.0 (21 May 2021)
 */
public class TimeConvert {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate date){
        return date.format(formatter);
    }

    public static LocalDate toDate(String date){
        return LocalDate.parse(date, formatter);
    }

    public static Boolean isDateVail(String date) {
        boolean flag = true; // Expectation tests and compare the value
        try {
            LocalDate.parse(date, formatter);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
