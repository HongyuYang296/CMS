import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeConvert {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(LocalDate date){
        return date.format(formatter);
    }

    public static LocalDate toDate(String date){
        return LocalDate.parse(date, formatter);
    }

    public static Boolean isDateVail(String date) {
        boolean flag = true;
        try {
            LocalDate.parse(date, formatter);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
