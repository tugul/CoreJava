JDBC - Java Database Connectivity
---

There are 4 important interfaces which are core of JDBC and implemented in every database driver. Those are:
- java.sql.Driver (for getting connection to database)
- java.sql.Connection (for communicating with database)
- java.sql.Statement (for running SQL)
- java.sql.ResultSet (for handling result returned by SELECT query)


In JDBC 4.0 and next versions, driver implementations are required to provide the name of the class implementing 
<i>Driver</i> interface in a file named <i>java.sql.Driver</i> in directory META-INF/service. By default, any updates are committed immediatelly. Autocommit can be disabled to commit several updates at once by calling Connection's <i>setAutoCommit(false)</i> and calling <i>commit()</i> method after playing several SQL statements. 


<i>ResultSet</i> has following get methods which take int or String as argument indicating column:
<ul>
<li>getBoolean</li>
<li>getDate (returns java.sql.Date)</li>
<li>getDouble</li>
<li>getInt</li>
<li>getLong</li>
<li>getObject</li>
<li>getString</li>
<li>getTime (returns java.sql.Time)</li>
<li>getTimeStamp (returns java.sql.TimeStamp)</li>
</ul>

Int argument indicates column number starting from 1. String argument indicates name of column from select statement<br><br>
<i>java.sql.Date, java.sql.Time, java.sql.TimeStamp</i> objects can be converted to <i>java.time.LocalDate, java.time.LocalTime, java.time.LocalDateTime</i>, respectively
