
**Java.nio** package is initially started to replace java.io package(Non-blocking io), but hasn't taken off until second version of nio API in Java 7 which is called nio2.
NIO2 actually intended to replace java.io.File class and its related interactions. 

Paths - factory/helper class for Path
Path refers to resource on filesystem which doesn't have to exist. And most of its operations doesn't require too. 
 
NIO2 API has following advantages over IO API:
* supports file-system dependent attributes (DOS, POSIX)
* allows you traverse directory hierarchy directly
* supports symbolic link in file system
* when reading multiple attributes of a file, it's faster
 


