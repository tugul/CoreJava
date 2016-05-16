package io;

import java.io.*;

/**
 * FileInputStream
 * FileOutputStream
 *
 * Those are used to read/write a byte from/to a file and their constructors take a File object or a string, denoting file path.
 * read() method returns -1 when indicating the end of the stream/file
 * read() returns primitive int type, similarly write() use int type to write a single byte to file.
 *
 * BufferedInputStream
 * BufferedOutputStream
 *
 * Buffered classes read/write data in bulk, rather than single byte by byte.
 * So performance is much higher than low level stream classes.
 * read() method returns 0 to indicate end of the stream.
 *
 * flush() - data in memory/cache will be immediately written into disk, to reduce loss of data in memory in case of crush
 * mark(int k)- if marking supported (check using boolean markSupported() before), marks current position in stream
 *              and keeps reading further k byte and calling reset() method moves pointer back to the marked position.
 *              In fact, a memory with limit of k bytes is allocated to store read bytes. Calling reset after the limit
 *              exceeds, runtime exception will be thrown as the mark is invalidated
 * skip(long k)- allows to skip given number of bytes when reading and returns long value indicating number of skipped bytes
 *
 */
public class UsingByteStreams {
    // Copy a file by reading/writing one byte at a time
    static void copyFile(String source, String target){
        try (FileInputStream in = new FileInputStream(new File(source));
            FileOutputStream out = new FileOutputStream(new File(target))){

            int byteData;
            while((byteData = in.read()) != -1){
                out.write(byteData);
            }

        } catch (IOException e){
            System.out.println("IO error occurred: " + e.getMessage());
        }
    }

    // Copy a file by reading/writing chunk of byte at a time, which is much faster
    static void copyFileViaBuffer(String source, String target){
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(source)));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(target)))){

            int bufferSize = 256;
            byte[] buffer = new byte[bufferSize];
            int readLength;
            while((readLength = in.read(buffer)) > 0){
                out.write(buffer, 0, bufferSize);
                out.flush();
            }
        }
        catch(IOException e){
            System.out.println("IO error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("io/README.md", "io/WRITE.me");
        copyFileViaBuffer("io/README.md", "io/WRITE.me");

        InputStream a;
        OutputStream o;

        BufferedInputStream st;
        BufferedOutputStream os;

        Reader r;
        Writer w;

        InputStreamReader isr;
        OutputStreamWriter osw;

        BufferedReader br;
        BufferedWriter bw;
    }
}
