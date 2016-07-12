package io;

import java.io.*;

/**
 * PrintStream (extends OutputStream) writes data as bytes
 * PrintWriter (extends Writer) writes data as characters
 *
 * High-level stream classes to write objects to text output stream in different formats
 * Both have a myriad of print methods which use write() method underneath.
 * It is recommended to use PrintWriter as it writes data as characters
 *
 * System.out is a reference of PrintWriter
 *
 * PrintWriter has format/printf methods which print output in specified format
 *
 */
public class UsingPrintClasses {
    public static void main(String[] args) throws IOException {
        PrintWriter out1 = new PrintWriter("output1.txt");
        PrintWriter out2 = new PrintWriter(new FileWriter("output2.txt"));
        PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter("output3.txt")));
        PrintWriter out4 = new PrintWriter(new BufferedWriter(new FileWriter(new File("output4.txt"))));

        out1.print(true);                    // PrintWriter method
        out1.write(String.valueOf(true));    // Writer method

        out2.print(4.55);                    // PrintWriter method
        out2.write(String.valueOf(4.55));    // Writer method

        out3.format("It is printed by format\n");
        out3.printf("It is printed by printf");
        out3.println(true);

        out1.close();
        out2.close();
        out3.close();
        out4.close();
    }
}
