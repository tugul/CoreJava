package datetimes;

import java.time.*;

/**
 * Created by bbn on 3/13/16.
 *
 * LocalTime - contains only time, no date info
 * LocalDate - contains only date, no time info
 * LocalDateTime - contains date and time
 *
 * All are immutable class and don't contain time zone info
 *
 * Period - contains longer span of time: days, weeks, months, years
 * Duration - contains short span of time: hours, minutes, seconds and nano
 */
public class CreateDateTimes {
    public static void main(String[] args) {
        // get current time
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(time);
        System.out.println(date);
        System.out.println(dateTime);

        // create date, time and datetime
        time = LocalTime.of(15, 45);
        date = LocalDate.of(2016, Month.MARCH, 30);
        dateTime = LocalDateTime.of(2016, 03, 30, 15, 45, 30, 300);
        dateTime = LocalDateTime.of(date, time);

        // For days, weeks, month, years
        Period fortNight = Period.ofWeeks(2);
        System.out.println(date.plus(fortNight));
        System.out.println(time.plus(fortNight)); // Runtime exception, can't add days to time

        // For hours, minutes, seconds, nanosecs
        Duration hourly = Duration.ofHours(1);
        System.out.println(time.plus(hourly));
        System.out.println(date.plus(hourly));  // Runtime exception, can't add hours to date
    }
}
