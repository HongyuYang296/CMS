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

}
