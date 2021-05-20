import java.time.LocalDate;//use the package
import java.time.format.DateTimeFormatter; //use the package

public class TimeConvert { //creating the TimeConvert class
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
