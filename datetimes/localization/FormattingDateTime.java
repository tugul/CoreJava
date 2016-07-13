package datetimes.localization;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * - DateTimeFormatter
 * used for printing and parsing date and time values
 *
 * - Format strings
 * Month : MMMM - January, MMM - Jan, MM - 01, M - 1
 * Year : yyyy - 2016, yy - 16,
 * Hour : hh - 12hour in 2 digits, HH - 24hour in 2 digits
 * Minute : mm - minutes in 2 digits
 * Second: ss - seconds in 2 digits
 *
 */
public class FormattingDateTime {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        // 1. Create format using pre-defined constants
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter isoTime = DateTimeFormatter.ISO_LOCAL_TIME;

        // Two ways to format date and time
        // format(DateTimeFormatter) - format DateTime object to String using chosen format as a parameter
        System.out.println(date.format(isoDate));       // 2016-06-04
        System.out.println(time.format(isoTime));       // 13:07:30.098
        System.out.println(dateTime.format(isoTime));   // 13:07:30.158
        System.out.println(dateTime.format(isoDate));   // 2016-06-04

        // format(LocalDate|LocalTime) - format DateTime parameter to String using format object
        System.out.println(isoDate.format(date));       // 2016-06-04
        System.out.println(isoTime.format(time));       // 13:07:31.198
        System.out.println(isoTime.format(time));       // 13:07:31.198
        //System.out.println(isoDate.format(time));   // Runtime exception, time can't be formatted as date

        // 2. Create format using pre-defined FormatStyle enum
        // ofLocalizedDate(FormatStyle)
        DateTimeFormatter localizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter localizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(dateTime.format(localizedDate));             //  6/4/16
        System.out.println(dateTime.format(localizedDateTime));         //  Jun 4, 2016 1:20:25 PM

        // 3. Create own format using pattern
        // ofPattern(String)
        DateTimeFormatter myTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println(time.format(myTimeFormat));          // 13:07:31
        //System.out.println(date.format(myTimeFormat));        // Runtime exception, only date can't be formatted as time
        System.out.println(dateTime.format(myDateFormat));      // June 04, 2016

        // Parse string into date and time

        // parse(String) - parses string value using ISO_LOCAL_DATE_TIME format
        // parse(String, DateTimeFormatter) - parses string value using given format
        // if format and String value are inconsistent, Java throws runtime exception
        String dateStr = "October 12, 2030";
        LocalDate parsedDate = LocalDate.parse(dateStr, myDateFormat);
        System.out.println(parsedDate);                                         // 2030-10-12
        System.out.println(LocalDateTime.parse("2030-10-12T13:50:43.397"));     // 2030-10-12T13:50:43.397
    }
}
