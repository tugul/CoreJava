package datetimes;

import java.time.*;

/**
 * LocalTime - contains only time, no date info
 * LocalDate - contains only date, no time info
 * LocalDateTime - contains date and time
 *
 * They don't contain time zone info
 *
 * Period - contains longer span of time: days, weeks, months, years
 * Duration - contains short span of time: hours, minutes, seconds and nano
 *
 * All those classes are immutable
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

        String s = "1";
        String b = s.concat("a").concat("b").concat("c");
        System.out.println(b);

        // create date, time and datetime
        time = LocalTime.of(15, 45);
        date = LocalDate.of(2016, Month.MARCH, 30);
        date.plusDays(10);            // As immutable class, it won't change its value, returned new object is wasted
        System.out.println(date);     // 2016-03-30, still same
        date = LocalDate.of(2016, Month.MARCH, 56);     // java.time.DateTimeException: Invalid value for DayOfMonth
        date = LocalDate.of(2016, Month.FEBRUARY, 30);  // java.time.DateTimeException: Invalid date 'FEBRUARY 30'
        dateTime = LocalDateTime.of(2016, 03, 30, 15, 45, 30, 300);
        dateTime = LocalDateTime.of(date, time);

        // For days, weeks, month, years
        Period fortNight = Period.ofWeeks(2);
        Period oneDay = fortNight.ofYears(1).ofDays(1); // Static method doesn't allow chaining, so last one considered
        System.out.println(date.plus(fortNight));   // 2016-04-13
        System.out.println(date.plus(oneDay));      // 2016-03-31
        System.out.println(time.plus(fortNight));   // Runtime exception, can't add days to time

        // For hours, minutes, seconds, nanosecs
        Duration hourly = Duration.ofHours(1);
        Duration oneSec = Duration.ofHours(3).ofSeconds(1); // Only last one's value is set
        System.out.println(time.plus(hourly));  // 16:45
        System.out.println(time.plus(oneSec));  // 15:45:01
        System.out.println(date.plus(hourly));  // Runtime exception, can't add hours to date
    }
}
