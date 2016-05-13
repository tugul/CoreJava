
_java.io_ package interacts with files and streams. I/O stream is a sequence of data and is completely different concept than Stream API of Java 8.

**Byte Stream:** 
Classes named with Stream are used for reading/writing all types of binary or byte data, including strings.
Abstract base classes: InputStream, OutputStream

**Character Stream:** 
Classes named with Reader/Writer are used for input/output of only character and String data. They make writing textual data to file easier and more convenient.
Abstract base classes: Reader, Writer

PrintWriter and PrintStream classes have no corresponding input or reader classes while other classes have always input and output corresponding classes.
PrintStream is a child class of OutputStream. 
 
Buffered classes read/write data in bulk, rather than single byte by byte. So performance is much higher than low level stream classes. 

