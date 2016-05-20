package nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * - Path
 * primary entry point of java.nio package
 * representation of path(file/directory) in a file system
 * path is system dependent, can't compare path from windows with one from unix based systems
 *
 */
public class UsingPath {
    public static void main(String[] args) throws URISyntaxException {
        // Create Path using helper class Paths
        Path path1 = Paths.get("README.md");
        Path path2 = Paths.get("..", "nio2/README.md");  // constructing paths

        System.out.println(path1.toAbsolutePath());
        System.out.println(path2.toAbsolutePath());

        // Path to URI resource
        Path path3 = Paths.get(new URI("file:/c:/user/google/docs")); // refer to URI based resource
        URI uri = path3.toUri();

        // Using FileSystem to create Path
        Path path4 = FileSystems.getDefault().getPath("README.md");
        FileSystem fileSystem = FileSystems.getFileSystem(new URI("ftp://user:pass@ftp-server-address"));
        Path path5 = fileSystem.getPath("README.md");

        // File to Path, and vice versa
        File file = new File("CoreJava/src/nio2/README.md");
        Path path6 = file.toPath();
        file = path6.toFile();

        System.out.println(path6);

        // path1.relativize(path2) - show path to reach from path1 to path2
        Path path11 = Paths.get("bo/fish.txt");
        Path path21 = Paths.get("birds.txt");
        System.out.println(path11.relativize(path21));
        System.out.println(path21.relativize(path11));

        // path1.resolve(path2) - 

    }
}
