package nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

/**
 * - File attribute
 * metadata, data about file or directory information
 * Files class provides many methods to interact with attributes of file/directory
 *
 * java.nio.file.attribute package:
 *
 * - FileTime class
 * container class to store date time attribute information about file
 *
 * - UserPrincipal interface
 * represents information about owner of file
 *
 * - File Attributes interfaces
 * BasicFileAttributes, DosFileAttributes, PosixFileAttributes
 * provides read-only information about all attributes of a file
 *
 * - File AttributeView interfaces
 * BasicFileAttributeView, DosFileAttributeView, PosixFileAttributeView
 * provides read/write access to information about all related attributes to file system
 *
 */
public class PathAttributes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("directory");
        if (!Files.exists(path))
            Files.createDirectory(path);

        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isRegularFile(path)); // return true for symbolic links if they refer to regular file

        System.out.println(Files.isHidden(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isReadable(path));

        // Files.size(Path) - returns size of file or directory in byte
        System.out.println(Files.size(path));   // 4096

        // Files.getLastModifiedTime(Path) - returns FileTime object
        // Files.setLastModifiedTime(Path) - set FileTime object
        FileTime lastModified = Files.getLastModifiedTime(path);
        System.out.println(lastModified);               // 2016-05-22T12:32:20.790266Z
        System.out.println(lastModified.toMillis());    // 1463920340790, milli-seconds

        lastModified = FileTime.fromMillis(System.currentTimeMillis()); // static method fromMillis()
        Files.setLastModifiedTime(path, lastModified);

        // Files.getOwner() - return UserPrincipal object representing owner information
        // Files.setOwner() - set owner
        UserPrincipal owner = Files.getOwner(path);
        System.out.println(owner.getName());            // bbn
        owner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("bbn");
        Files.setOwner(path, owner);

        // Files.getAttribute(Path, String, LinkOption...) - get any attribute's information by single call
        // Files.setAttribute(Path, String, Object, LinkOption...) - set value to any attribute
        owner = (UserPrincipal) Files.getAttribute(path, "owner");
        Files.setAttribute(path, "owner", owner);

        // FileAttributes, FileAttributeView
        // provides access to all attributes information retrieved by a single call

        // FileAttributes interface provides read-only access to all attributes information
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(attributes.isDirectory());
        System.out.println(attributes.creationTime());
        System.out.println(attributes.size());

        // FileAttributeView provides read/write access to all attributes of a file
        BasicFileAttributeView attributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes readOnlyAttributes = attributeView.readAttributes();
        FileTime lastModifiedTime = FileTime.fromMillis(readOnlyAttributes.creationTime().toMillis() + 1000);
        // setTimes(LastModifiedTime, LastAccessTime, CreatedTime), null value means don't modify
        attributeView.setTimes(lastModifiedTime, null, null);

    }
}
