package datetimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

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
        
        // Tricky case, for real brainier
        // Time difference from 3am --> 2am is normally -1
        // However during exact time shift, 2am + 1h = 2am and 2am + 2h = 3am. 
        // so difference is 2 and we are subtracting, so it is -2
		LocalDateTime ld1 = LocalDateTime.of(2016, Month.OCTOBER, 30, 3, 0);
		LocalDateTime ld2 = LocalDateTime.of(2016, Month.OCTOBER, 30, 2, 0);
		ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("Europe/Stockholm"));
		ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("Europe/Stockholm"));
		long difference = ChronoUnit.HOURS.between(zd1, zd2); 	
		System.out.println(difference); 		// -2
    }
}
