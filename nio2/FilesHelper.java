package nio2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * - java.nio.file.Files
 * provides useful methods many of which are similar to methods in java.io.File
 * most of its method throws IOException
 * most of its method takes optional varargs: values of StandardCopyOption enum
 * 
 * StandardCopyOption.ATOMIC_MOVE : operation performed as seemingly instant even it is time-taking and huge 
 * StandardCopyOption.COPY_ATTRIBUTES : all metadata will be copied with file
 * StandardCopyOption.NOFOLLOW_LINKS : if symbolic link, its target won't be traversed
 * StandardCopyOption.REPLACE_EXISTING : the operation will override target file if that exists 
 *
 */
public class FilesHelper {
    public static void main(String[] args) throws IOException {
        // Files.exists(Path) - check if path exists in file system
        Path path = new File("src/nio2/README.md").toPath();
        System.out.println(Files.exists(path));

        // Files.isSameFile(Path, Path) - check if 2paths refer to same file in filesystem
        // it returns FALSE if same file exist in different locations. (For symbolic link, its target file is considered)
        Path path1 = Paths.get("src/io/../nio2/README.md");
        System.out.println(path1 == path);                      // false, different objects
        System.out.println(Files.isSameFile(path1, path));      // true, but refers to same file
        System.out.println(path1.equals(path));                 // false, composed of different paths
        System.out.println(path1.normalize().equals(path));     // true, after normalized, composed of same paths

        // Files.createDirectory(Path) - creates single directory. If any of its parent doesn't exist, throws exception
        // Files.createDirectories(Path) - creates directory structure
        // if directory already exists, throws FileAlreadyExistsException
        if (!Files.exists(Paths.get("files")))
            Files.createDirectory(Paths.get("files"));
        if (!Files.exists(Paths.get("hem/dom/nom")))
            Files.createDirectories(Paths.get("hem/dom/nom"));

        // Files.copy(Path, Path) - copy file or directory (shallow copy for directory: content not copied)
        // origin must exist and destination must not. Otherwise, throws exception
        if (Files.exists(Paths.get("origin")) && !Files.exists(Paths.get("destination")))
            Files.copy(Paths.get("origin"), Paths.get("destination"));

        Path inputFile = Paths.get("input.txt");
        if (!Files.exists(inputFile))
            Files.createFile(inputFile);

        // Files.copy(InputStream, Path) - copy from stream to file
        // Files.copy(Path, OutputStream) - copy file into stream
        InputStream in = new FileInputStream(inputFile.toFile());
        OutputStream out = new FileOutputStream("output.txt");

        boolean isDeleted = Files.deleteIfExists(Paths.get("fromStream.out"));
        Files.copy(in, Paths.get("fromStream.out"));
        Files.copy(inputFile, out);

        // Files.move(Path, Path, CopyOption...) - moves/renames file/dir/link (move with its contents for dir)
        // moving non-empty directory across drive is not supported
        // moving always preserves all attributes to target file even when COPY_ATTRIBUTES flag is not set
        // if destination path is dir, it must be empty
        if (!Files.exists(Paths.get("destinationDir")))
            Files.move(Paths.get("hem"), Paths.get("destinationDir"));

        // Files.delete(Path) - deletes file or non-empty directory, throws exception if doesn't exist
        // Files.deleteIfExists(Path) - same as above, but returns boolean false instead of throwing exception
        Files.delete(Paths.get("fromStream.out"));
        Files.deleteIfExists(Paths.get("fromStream.out"));

        // Files.newBufferedReader(Path, Charset) - read a file using java.io stream, returns BufferedReader object
        // Files.newBufferedWriter(Path, Charset) - write a file using java.io stream, returns BufferedWriter object
        BufferedReader br = Files.newBufferedReader(inputFile, Charset.forName("UTF-8"));
        BufferedWriter bw = Files.newBufferedWriter(inputFile, Charset.forName("UTF-8"));
        br.close();
        bw.close();

        // Files.readAllLines(Path) - read a file once and return a list whose an element is a single line of the file
        // Throws OutOfMemoryError if file is huge. Files.lines(Path) is more efficient as it uses lazy loading
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        
        // Searching in a directory
        // Files.find(Path, int depth, BiPredicate) - same as walk method except for depth parameter
        Files.find(Paths.get("dir"), 10, (a,b) -> b.isRegularFile()).forEach(System.out::println);
    }
}
