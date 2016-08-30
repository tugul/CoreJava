package datetimes;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * - Instant class
 * concrete final class representing specific moment in GMT time zone
 * ZonedDateTime can be converted to Instant, but not LocalDateTime as it doesn't have time zone info
 * 
 */
public class UsingInstant {
    public static void main(String[] args) {
        // 1. Create via static method now()
        Instant blink = Instant.now();

        // 2. Convert ZonedDateTime to Instant
        ZonedDateTime nowZoned = ZonedDateTime.now();
        Instant nowInstant = nowZoned.toInstant();
        System.out.println(nowZoned);                   // 2016-05-31T23:12:41.188+02:00[Europe/Stockholm]
        System.out.println(nowInstant);                 // 2016-05-31T21:12:41.188Z

        // 3. Create from Epoch second (since 1970.01.01 00:00:00)
        Instant fromEpoch = Instant.ofEpochSecond(60);
        System.out.println(fromEpoch);                  // 1970-01-01T00:01:00Z

        // Manipulation
        Instant tomorrow = nowInstant.plus(1, ChronoUnit.DAYS);
        Instant nextHour = nowInstant.plus(1, ChronoUnit.HOURS);
        Instant nextWeek1 = nowInstant.plus(7, ChronoUnit.DAYS);
        Instant nextWeek2 = nowInstant.plus(1, ChronoUnit.WEEKS);       // Exception: Unsupported unit: Weeks
        Instant nextYear = nowInstant.plus(1, ChronoUnit.YEARS);        // Exception: Unsupported unit: Years
        Instant nextDecades = nowInstant.plus(1, ChronoUnit.DECADES);   // Exception: Unsupported unit: Decades

        System.out.println(tomorrow);           // 2016-06-01T21:12:41.188Z
        System.out.println(nextHour);           // 2016-05-31T22:12:41.188Z
        System.out.println(nextWeek1);          // 2016-06-07T21:12:41.188Z
        
        // Instant truncatedTo(TemporalUnit unit)
        // Returns a copy of given instant whose units' values after given unit are truncated 
        Instant now = Instant.now();								// 2016-08-30T14:37:30.747Z
        System.out.println(now.truncatedTo(ChronoUnit.MINUTES));	// 2016-08-30T14:37:00Z
        System.out.println(now.truncatedTo(ChronoUnit.HOURS));		// 2016-08-30T14:00:00Z
        System.out.println(now.truncatedTo(ChronoUnit.DAYS));		// 2016-08-30T00:00:00Z
    }
}
