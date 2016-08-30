package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * - Parallel stream
 * A stream that can process result in parallel by using multiple threads. Although performance 
 * increase can be achieved, it can change the result unexpectedly if not used carefully.
 * 
 * - Create parallel stream
 * parallel() - converts an existing stream into a parallel stream. As it is an intermediate operation,
 * 				any operation on the parallel stream will affect on original stream.  
 * 
 * parallelStream() - create a parallel stream from a collection data
 * 
 * - Notes on its usage
 * Stateful operations should be avoided on parallel stream. Stateful operation is one that 
 * produces a result by processing entire input first. For example, sort or findAny in stream etc.
 * When using reduce() method on parallel streams, it is good to note that although the 1 and 2-argument 
 * reduce() methods support parallel processing, it is recommended to use the 3-argument version of 
 * reduce() when working with parallel streams. To do that, we have to define Identity, Accumulator 
 * and Combiner as a argument. Then using parallel stream will result consistent and ordered output. 
 * It is same for 3-argument version of collect() method
 * 
 */
public class ParallelStream {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// Create two identical streams from same collection
		Stream<Integer> stream1 = numbers.stream();
		Stream<Integer> stream2 = numbers.stream();
		
		System.out.println("Stream2 is parallel? : " + stream2.isParallel());	// false
		
		// always print 123456
		stream1.forEach(i -> System.out.print(i));	
		
		// Convert a stream into a parallel stream
		Stream<Integer> parallelStream1 = stream2.parallel();
		
		// Create new parallel stream from collection
		Stream<Integer> parallelStream2 = numbers.parallelStream();
		
		System.out.println();
		
		// Converting stream into parallel one makes original stream parallel too
		System.out.println("Stream2 is parallel? : " + stream2.isParallel());	// true
		
		// Stream composed of parallel or non-parallel streams is non parallel 
		System.out.println("Stream of mixed streams is parallel? : " + Stream.of(stream1, stream2).isParallel());
		System.out.println("Stream of parallel stream is parallel? : " + Stream.of(parallelStream1, parallelStream2).isParallel());
		
		// output is UNPREDICTABLE
		// it will print in parallel, one possibility: 462531
		stream2.forEach(System.out::print);
		
		// Throws IllegalStateException as original stream2 is closed when used with forEach(...)
		parallelStream1.forEach(System.out::print);
		
		System.out.println();
		
		// Order the processing using ordered version of forEach method
		// Output is 123456. But performance gain is lost
		parallelStream2.forEachOrdered(System.out::print);
	}
}

