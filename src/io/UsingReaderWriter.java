package io;

import java.io.*;
import java.util.*;

/**
 *
 * FileReader, FileWriter
 * BufferedReader, BufferedWriter
 *
 * Those classes and their buffered classes are most commonly used as they provide a way to directly read/write chars into a file.
 *
 */
public class UsingReaderWriter {

    // Read text file line by line using BufferedReader
    static List<String> readTextFile(String source){
        List<String> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(source)))){
            String line;
            while((line = br.readLine()) != null){
                content.add(line);
            }
        }
        catch(IOException e){
            System.out.println("IO error occurred: " + e.getMessage());
        }

        return content;
    }

    // Write text file line by line using BufferedWriter
    static void writeTextFile(List<String> content, String target){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(target)))){
            for (String line : content){
                bw.write(line + "\n");
            }
        }
        catch (IOException e){
            System.out.println("IO error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> fileContent = readTextFile("io/README.md");
        writeTextFile(fileContent, "io/WRITE.OUT");
    }
}
