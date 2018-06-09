# Date and Time

New package ``java.time`` addresses the shortcommings of old date and time in ``java.util`` package. 

## Features
``java.time`` package provides following features out of box, including but not limited to: 
- Simpler and flexible creation of objects
- Thread-safety through its immutabile classes
- Method chaining in functional programming style for complex transformations 
- Better representation of dates in time zones and chronologies
- Truncation of values in any field of dates and times
- Flexible parsing and formatting of dates and times
- Interoperability with old Java dates and times

## Members
``java.time`` package encompasses versatile representations of use cases related with date and timing. Majority of them are listed below:  

- **LocalDate** – a simple date (year, month, day)  
- **LocalTime** – time with nanosecond precision and without date info
- **LocalDateTime** – same as LocalDate, but includes time with nanosecond precision  
- **ZonedDateTime** – same as OffsetDateTime, but includes a time zone ID  
- **OffsetDateTime** – same as LocalDateTime, but with time zone offset  
- **OffsetLocalTime** – same as LocalTime, but with time zone offset  
- **Instant** – represents a point in time (timestamp)  
- **MonthDay** – month and day, without year or time  
- **YearMonth** – month and year, without day or time  
- **Duration** – time period represented in seconds, minutes and hours with nanosecond precision  
- **Period** – time period represented in days, months and years  
- **ZoneId** – time-zone id and used to convert Instant and LocalDateTime
