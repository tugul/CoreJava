package streams;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * - Optional
 * introduced in Java 8 to reduce null pointer exceptions
 * container type wrapping a single value which might be absent or present
 * more expressive than null, so supports functional programming style
 *
 * - Caller of method returning Optional
 * should use ifPresent to check value is present or not
 * use get() returns the value
 * or use orElse, orElseGet or orElseThrow to deal with absent case
 *
 */
public class AboutOptional {

    public static Optional<Double> findAverage(int... nums){
        if (nums.length == 0)
            return Optional.empty();

        return Optional.of((double)IntStream.of(nums).sum() / nums.length);
    }

    public static void main(String[] args) {
        System.out.println(findAverage(10, 30));    // Optional[20.0]
        System.out.println(findAverage());          // Optional.empty

        Double avg1 = findAverage(10, 20).get();    // 20.0
        Double avg2 = findAverage().get();          // NoSuchElementException

        Optional<Double> avgOpt = findAverage();
        if (avgOpt.isPresent())
            System.out.println(avgOpt.get());
        avgOpt.ifPresent(System.out::println);   // no result

        System.out.println(avgOpt.orElse(Double.NaN));
        System.out.println(avgOpt.orElseGet(() -> Math.random()));  // orElseGet takes double
        System.out.println(avgOpt.orElseThrow(() -> new IllegalStateException()));

        // Ternary operator to avoid null can be replaced with Optional.ofNullable(...)
        Object value = null;
        Optional obj1 = (value== null) ? Optional.empty(): Optional.of(value);
        Optional obj2 = Optional.ofNullable(value);

    }
}
