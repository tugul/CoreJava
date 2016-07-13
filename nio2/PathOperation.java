package nio2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path interface provides numerous methods to interact with Path objects which return new Path object
 *
 */
public class PathOperation {
    public static void main(String[] args) throws IOException {
        // getParent() - Get parent path (immediate path)
        System.out.println(Paths.get("/home/files").getParent());   // /home
        System.out.println(Paths.get("/home").getParent());         // /
        System.out.println(Paths.get("/").getParent());             // null, no parent to root
        System.out.println(Paths.get("home/files").getParent());    // home
        System.out.println(Paths.get("home/").getParent());         // null, no parent to relative path

        // getRoot() - returns root as path object
        System.out.println(Paths.get("home/files").getRoot());        // returns null for relative path as no root specified
        System.out.println(Paths.get("/home/files").getRoot());       // return '/'

        // getNameCount() - returns the total number of parts composing the path
        // getName(int) - returns each composing Path at given index
        Path path = Paths.get("/home/files/precis.txt");
        System.out.println("Complete path: " + path);
        for(int i=0; i<path.getNameCount(); i++)
            System.out.println("Element at " + i + " is: " + path.getName(i));

        // getFileName() - returns only last part of path as new Path object
        System.out.println("File name: " + path.getFileName());

        // isAbsolute() - check whether a path is absolute or not
        // toAbsolutePath() - make given path absolute
        System.out.println(Paths.get("/home/files").isAbsolute());        // true
        System.out.println(Paths.get("/home/files").toAbsolutePath());    // return same object back if already absolute
        System.out.println(Paths.get("home/files").toAbsolutePath());     // returns CURRENT_DIR + given path

        // toRealPath() - locates given Path in filesystem (cleanse up the path)
        System.out.println(Paths.get("src/nio2/README.md").toRealPath());   // return absolute path of given path if exists, otherwise IOException
        System.out.println(Paths.get(".").toRealPath());                    // prints full path of current directory

        // subpath(int, int) - works same as substring, start index inclusive, end index non-inclusive
        System.out.println(Paths.get("home/files/symbol.pkg").subpath(1,3)); // files/symbol.pkg

        // relativize(Path) - shows path to reach given Path from target path (not from current dir!!!)
        // requires both paths to be relative or absolute. Otherwise, throws IllegalArgumentException
        Path path1 = Paths.get("aa");
        Path path2 = Paths.get("bb");
        System.out.println(path1.relativize(path2));    // ../bb
        System.out.println(path2.relativize(path1));    // ../aa

        Path path3 = Paths.get("/aa/bb");
        Path path4 = Paths.get("/cc/");
        System.out.println(path3.relativize(path4));    // ../../cc
        System.out.println(path4.relativize(path3));    // ../aa/bb

        Path path5 = Paths.get("/cc/bb");
        Path path6 = Paths.get("/cc/");
        System.out.println(path5.relativize(path6));    // ..
        System.out.println(path6.relativize(path5));    // bb

        Path path7 = Paths.get("aa/bb");
        Path path8 = Paths.get("cc/");
        System.out.println(path7.relativize(path8));    // ../../cc
        System.out.println(path8.relativize(path7));    // ../aa/bb

        // resolve(Path) - join paths. If parameter path is absolute, it will overwrite
        path3 = Paths.get("/aa/bb");
        path4 = Paths.get("/cc");
        path8 = Paths.get("cc/");
        System.out.println("Resolved: " + path3.resolve(path4));    //  /cc
        System.out.println("Resolved: " + path3.resolve(path8));    //  /aa/bb/cc

        // normalize() - clean up path
        path = Paths.get("/aa/bb/../cc/../dd");
        System.out.println("Cleaned up: " + path.normalize());      //  /aa/dd
        // normalize() doesn't convert relative path to absolute
        Path currentDir = Paths.get(".");
        System.out.println(currentDir);                             // .
        System.out.println(currentDir.normalize());                 // .
        System.out.println(currentDir.toAbsolutePath());            // /home/bbn/IdeaProjects/CoreJava/.
    }
}
