package exception;

import java.io.Closeable;

/**
 * - Try statement
 * must be followed by either or both of catch and finally blocks
 * requires tedious work to declare resources outside block and to close them in finally block
 *
 * - Try with resource
 * introduced in Java 7
 * doesn't require any catch or finally block
 * resource is automatically closed at the end of try block (implicit finally block is executed)
 * Resource class must implement interface java.lang.AutoClosable
 * If several resource are opened, they are closed in reverse order
 *
 * - java.io.Closeable
 * resource can implement this interface as it extends interface AutoClosable
 * its close only throws IOException while AutoClosable's close can throw any exception
 *
 */
class Box implements AutoCloseable {
    int id;
    public Box(int size) {
        this.id = size;
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("Box " + id +" is closed");
    }
}

class FragileBox implements Closeable {
    @Override
    public void close() throws RuntimeException {
        throw new RuntimeException("can't close");
    }
}

class BrokenBox implements AutoCloseable {
	@Override
	public void close() throws Exception {
	}
}

public class TryWithResource {
    public static void main(String[] args) {
        try (Box box1 = new Box(10);
            Box box2 = new Box(20)){
            System.out.println("Look inside the box");
        }

        try(FragileBox box = new FragileBox()){
            System.out.println("Box is open");
        }
        catch (RuntimeException e){
            System.out.println("Caught: " + e.getMessage());
        }
        finally {
            System.out.println("Oh, finally!");
        }
        
        try (BrokenBox bb = new BrokenBox()){	// DOES NOT COMPILE, checked exception is not handled or declared
        }
        finally{}
    }
}
/* It prints:

  Look inside the box
  Box 20 is closed
  Box 10 is closed
  Box is open
  Caught: can't close
  Oh, finally!
*/

