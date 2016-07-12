package io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * - There are common 3 ways to read data from console
 * Use java.util.Scanner
 * Use java.io.BufferedReader
 * Use java.io.Console
 *
 * - java.io.Console
 * Introduced in Java 6 and singleton class which has many convenient methods
 * Its single instance created by JVM and accessed by System.console() method
 * Can't be used in non-interactive environment and System.console() returns Null
 * format()/printf() are only 2 methods to write out.
 * reader() and writer() methods return Reader and PrintWriter instances, respectively
 * and they are analogous to System.in and System.out. However, System.in and System.out
 * are just raw streams whereas Console provides many convenient methods
 *
 * readPassword() - reads password without showing what user types and returns char array instead of String
 * readPassword(String fmt, Object... arg) - overloaded one with specific prompt message etc.
 *
 */
public class ReadConsole {
    // Runs faster, but longer statement
    static String readConsoleByBufferedReader() throws IOException {
        String input;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter any value: ");
            input = br.readLine();
        }
        return input;
    }

    // Terse syntax and has useful method to parse primitive values, but slower to read than BufferedReader
    static String readConsoleByScanner() {
        String input;
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter any value: ");
            input = scanner.nextLine();
        }
        return input;
    }

    // Has more convenient methods
    static String readConsoleByIOConsole(){
        Console console = System.console(); // Singleton instance
        String input = null;
        // System.console() returns null if text interaction is not supported
        if (console == null)
            System.out.println("User console is not available");
        else {
            console.writer().println("You are using io.Console");

            input = console.readLine("Enter any value: ");
            char[] password = console.readPassword("Enter your password:");
            console.writer().format("Your password: %s\n", String.valueOf(password));
        }
        return input;
    }


    public static void main(String[] args) throws IOException {
        String value;
        // To use any of them uncomment others
        //value = readConsoleByBufferedReader();
        //value = readConsoleByScanner();
        value = readConsoleByIOConsole();

        System.out.println("You entered: " + value);
    }
}
