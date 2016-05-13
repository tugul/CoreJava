package nio2;

import java.io.*;

/**
 * FileInputStream
 * FileOutputStream
 *
 * Those are used to read/write bytes from/to a file and their constructors take a File object or a string, denoting file path.
 *
 * BufferedInputStream
 * BufferedOutputStream
 *
 * Buffered classes read/write data in bulk, rather than single byte by byte. So performance is much higher than low level stream classes.
 *
 */
public class UsingStreams {
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

            byte[] buffer = new byte[1024];
            int readLength;
            while((readLength = in.read(buffer)) > 0){
                out.write(buffer, 0, 1024);
                out.flush();
            }
        }
        catch(IOException e){
            System.out.println("IO error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("nio2/README.md","nio2/WRITE.me");
        copyFileViaBuffer("nio2/README.md","nio2/WRITE.me");

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
