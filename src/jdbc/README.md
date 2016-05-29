JDBC - Java Database Connectivity

There are 4 important interfaces which are core of JDBC and implemented in every database driver. Those are:
- java.sql.Driver (for getting connection to database)
- java.sql.Connection (for communicating with database)
- java.sql.Statement (for running SQL)
- java.sql.ResultSet (for handling result returned by SELECT query)


In JDBC 4.0 and next versions, driver implementations are required to provide the name of the class implementing 
Driver interface in a file named java.sql.Driver in directory META-INF/service. 





