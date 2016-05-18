
Java.nio package is initially started to replace java.io package(Non-blocking io), but hasn't taken off until second version of nio API in Java 7 which is called nio2.
NIO2 actually intended to replace java.io.File class and its related interactions. 

Paths - factory/helper class for Path
Path refers to resource on filesystem which doesn't have to exist. And most of its operations doesn't require too. 
However, Path.toRealPath()
 
 

