package datetimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * - Daylight saving
 * Some countries use it to save daylight. Java handles it smart enough
 *
 * In spring, time springs from 01:59 till 03:00. Add 1hour to current time zone
 * In fall, time falls from 02:59 back till 02:00. Subtract 1hour from current time zone
 */
public class DaylightSaving {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Europe/Stockholm");

        // Time goes 1 hour forward in March
        // timezone switches to 1 hour higher
        LocalDate date = LocalDate.of(2016, 03, 27);
        LocalTime time = LocalTime.of(1, 0);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone); // Time
        System.out.println(zonedDateTime);                      // 2016-03-27T01:00+01:00[Europe/Stockholm]
        System.out.println(zonedDateTime.plusHours(1));         // 2016-03-27T03:00+02:00[Europe/Stockholm]

        // Time fall 1 hour back in November
        // timezone switches to 1 hour lower
        date = LocalDate.of(2016, 10, 30);
        time = LocalTime.of(2, 30);
        zonedDateTime = ZonedDateTime.of(date, time, zone); // Time
        System.out.println(zonedDateTime);                      // 2016-10-30T02:30+02:00[Europe/Stockholm]
        System.out.println(zonedDateTime.plusHours(1));         // 2016-10-30T02:30+01:00[Europe/Stockholm]
        System.out.println(zonedDateTime.plusHours(2));         // 2016-10-30T03:30+01:00[Europe/Stockholm]
    }
}
