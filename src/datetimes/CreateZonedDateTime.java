package datetimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * - ZonedDateTime
 * immutable representation of date-time with time zone.
 *
 * Manipulating zoned date time is same as doing for local date time
 *
 */
public class CreateZonedDateTime {
    public static void main(String[] args) {
        // 1. Create from current moment
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println(zonedDateTime1);

        // 2. Create from given local date, local time and zone
        ZoneId zone = ZoneId.of("Europe/Berlin");
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(dateNow, timeNow, zone);

        // 3. Create from local date time and zone
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime, zone);

        // 4. Create by specifying every detail in constructor
        ZonedDateTime zonedDateTime4 = ZonedDateTime.of(2016, 05, 29, 11, 30, 0, 100, zone);

        // 5. Parse from String
        ZonedDateTime zonedDateTime5 = ZonedDateTime.parse("2016-05-29T13:30:00+04:00[Europe/Berlin]");

        // Get all time-zones and filter
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("Eu"))
                .sorted().forEach(System.out::println);

        // Date time to Epoch (long value)
        // it converts date and date time to long value relative to Jan 01, 1970
        // LocalDateTime/ZonedDateTime have one and only method toEpochSecond()
        zonedDateTime1.toEpochSecond();
        localDateTime.toEpochSecond(ZoneOffset.MAX);

        // LocalDate has 2 methods toEpochDay() / fromEpochDay(long)
        LocalDate localDate = LocalDate.now();
        localDate.toEpochDay();

        // isBefore()
        LocalDate may30 = LocalDate.of(2016, 05, 30);
        LocalDate jun01 = may30.plusDays(2);
        System.out.println(may30.isAfter(jun01));     // false
        System.out.println(may30.isBefore(jun01));    // true

        // between(Temporal, Temporal) - determines difference between Temporals and returns long
        System.out.println(ChronoUnit.DAYS.between(may30, jun01));      // 2
        System.out.println(Period.between(may30, jun01));               // P2D
        System.out.println(ChronoUnit.MONTHS.between(may30, jun01));    // 0   , truncates rather than rounding
    }
}
