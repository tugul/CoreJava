package io;

import java.io.File;
import java.io.IOException;

/**
 * - java.io.File class
 * represents a record in file system which contains user or system data
 * used to provides accesses to files/directories in file system, but not itself provide the accesses
 *
 */
public class AboutFileClass {
    public static void main(String[] args) throws IOException {
        File file = new File("note.txt");
        file.createNewFile();

        // length() - returns number of bytes in file
        System.out.println(file.length());

        // renameTo(File) - rename to given File object's name
        file.renameTo(new File("renamed_note.txt"));

        // Unix based systems use forward slash
        File psxFile = new File("/usr/bin");

        // Windows based systems use backward slash
        File dosFile = new File("c:\\users\\user");
        System.out.println(File.separator);     // prints separator character

        // mkdirs() - creates directory structure
        // mkdir() - create single directory. If called on dir structure, it will do nothing
        File singleDir = new File("emptyDir2/again");
        singleDir.mkdir();      // do nothing as File is directory structure
        singleDir.mkdirs();     // will create directory structure

        System.out.println(singleDir.getAbsolutePath());    // returns String
        System.out.println(singleDir.getAbsoluteFile());    // returns new File object



    }
}
