package datetimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 */
public class DateTimeFormatterAndParse {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // 3. DateTimeFormatter
        DateTimeFormatter shortDateFormat = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(date.format(shortDateFormat));   // 20160313
        System.out.println(shortDateFormat.format(date));   // 20160313
        //System.out.println(shortDateFormat.format(time));   // Runtime exception, time can't be formatted as date

        // create own format
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(time.format(timeFormat));     // 11:00
        //System.out.println(date.format(timeFormat)); // Runtime exception, only date can't be formatted as time
        System.out.println(dateTime.format(timeFormat)); // 11:00
    }
}
