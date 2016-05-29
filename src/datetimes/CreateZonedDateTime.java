package datetimes;

import java.time.*;

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
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(now, zone);

        // 4. Create by specifying every detail in constructor
        ZonedDateTime zonedDateTime4 = ZonedDateTime.of(2016, 05, 29, 11, 30, 0, 100, zone);

        // 5. Parse from String
        ZonedDateTime zonedDateTime5 = ZonedDateTime.parse("2016-05-29T13:30:00+04:00[Europe/Berlin]");

        // Get all time-zones and filter
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("Eu"))
                .sorted().forEach(System.out::println);

    }
}
