package datetimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

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
        String b = s.concat("a").concat("b").concat("c");       // 1abc, instance method allows chaining
        System.out.println(b);

        // create date, time and datetime
        time = LocalTime.of(15, 45);
        date = LocalDate.of(2016, Month.MARCH, 30);
        date.plusDays(10);            // As immutable class, it won't change its value, returned new object is wasted
        date.plusMonths(3);
        date.minusWeeks(1);
        System.out.println(date);     // 2016-03-30, still same
        date = LocalDate.of(2016, Month.MARCH, 56);     // java.time.DateTimeException: Invalid value for DayOfMonth
        date = LocalDate.of(2016, Month.FEBRUARY, 30);  // java.time.DateTimeException: Invalid date 'FEBRUARY 30'
        dateTime = LocalDateTime.of(2016, 03, 30, 15, 45, 30, 300);
        dateTime = LocalDateTime.of(date, time);

        // Period - for days, weeks, month, years, decades
        Period fortNight = Period.ofWeeks(2);
        Period oneDay = fortNight.ofYears(1).ofDays(1); // Static method doesn't allow chaining, so last one considered
        Period year2Month7Days = Period.of(1, 2, 7);    // period of specified year, month and day
        System.out.println(date.plus(fortNight));       // 2016-04-13
        System.out.println(date.plus(oneDay));          // 2016-03-31
        System.out.println(time.plus(fortNight));     // Runtime exception, can't add days to time
        System.out.println(fortNight);                  // P14D
        System.out.println(oneDay);                     // P1D
        System.out.println(year2Month7Days);            // P1Y2M7D

        // Duration - for hours, minutes, seconds, nano-secs
        Duration hourly = Duration.ofHours(1);
        Duration oneSec = Duration.ofHours(3).ofSeconds(1); // Only last one's value is considered as for static methods
        System.out.println(time.plus(hourly));  // 16:45
        System.out.println(time.plus(oneSec));  // 15:45:01
        System.out.println(date.plus(hourly));  // Runtime exception, can't add hours to date
        System.out.println(hourly);                 // PT1H     - period of time 1 hour
        System.out.println(oneSec);                 // PT1S
        System.out.println(Duration.ofDays(1));     // PT24H
        System.out.println(Duration.ofMillis(1));   // PT0.001S
        System.out.println(Duration.ofNanos(1));    // PT0.000000001S

        Duration daily = Duration.of(1, ChronoUnit.DAYS);
        Duration every5min = Duration.of(5, ChronoUnit.MINUTES);
        Duration every5sec = Duration.of(5, ChronoUnit.SECONDS);
    }
}
