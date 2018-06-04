# NIO (Non-blocking IO)

``java.nio`` package is initially started to replace ``java.io`` package(Non-blocking io), however it hasn't taken off until the second version of nio API in Java 7 which is called **nio2**. **NIO2** actually intended to replace ``java.io.File`` class and its related interactions. 

- ``java.nio.file.Path`` refers to resource on filesystem which doesn't have to exist. And most of its operations don't require it too. 
- ``java.nio.file.Paths`` is a factory/helper class for ``Path``

 
**NIO2** API has following advantages over old **IO** API:
* supports file-system dependent attributes (DOS, POSIX)
* allows you directly traverse directory hierarchy
* supports symbolic link in file system
* faster when reading multiple attributes of a file 


