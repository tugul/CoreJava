package nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - java.nio.file.Path
 * primary entry point of java.nio package
 * representation of path(file/directory) in a file system
 * Path is system dependent, can't compare path from DOS/Windows with one from Unix based systems
 *
 * Path object can be created various ways 
 *
 */
public class PathCreation {
    public static void main(String[] args) throws URISyntaxException {

        // 1. Create Path using Paths helper class
        Path path1 = Paths.get("README.md");
        Path path2 = Paths.get("..", "nio2/README.md");  // constructing paths

        System.out.println(path1.toAbsolutePath());
        System.out.println(path2.toAbsolutePath());

        // 2. Construct Path from URI resource
        Path path3 = Paths.get(new URI("file:/c:/user/google/docs")); // refer to URI based resource
        URI uri = path3.toUri();

        // 3. Create Path from default file system
        Path path4 = FileSystems.getDefault().getPath("README.md");

        // 4. Create path for remote file system
        //FileSystem fileSystem = FileSystems.getFileSystem(new URI("ftp://username:password@ftp.the-ftp-server.com"));
        //Path path5 = fileSystem.getPath("README.md");

        // 5. Create path from File object. File to Path, and vice versa
        File file = new File("CoreJava/src/nio2/README.md");
        Path path6 = file.toPath();
        file = path6.toFile();

        String pathStr = file.getPath();
        System.out.println("Path string: " + pathStr);
    }
}