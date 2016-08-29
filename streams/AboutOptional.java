package streams;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * - Optional 
 * final class in java.util package
 * introduced in Java 8 to reduce null pointer exceptions
 * container type wrapping a single primitive or object which might be absent or present
 * more expressive than null, so supports functional programming style
 *
 * - Static methods to create Optional
 * Optional<T> of - creates optional with given value. Can't create value from null, so ofNullable is safer
 * Optional<T> ofNullable(T) - creates optional with given value. If the value is null, it creates Optional.empty()
 * Optional<T> empty() - creates optional object with empty value in it
 * 
 * - Caller of a method returning Optional
 * should use ifPresent to check value is present or not
 * T get() - returns the wrapped value or throws NoSuchElementException if the value is empty/absent
 * boolean isPresent() - check if value is present or not
 * void ifPresent(Consumer<T>) - call Consumer parameter if value is present
 *
 * - To deal with absent case / if value in Optional is absent
 * T orElse(T) - returns given parameter value
 * T orElseGet(Supplier<T>) - returns result of Supplier
 * T orElseThrow(Supplier<Throwable>) - throws exception
 *
 * - Primitive Optional classes with methods specific to their types
 * OptionalInt - getAsInt(), orElse(int), orElseGet(IntSupplier)
 * OptionalLong - getAsLong(), orElse(long), orElseGet(LongSupplier)
 * OptionalDouble - getAsDouble(),orElse(double), orElseGet(DoubleSupplier)
 *
 */
public class AboutOptional {

    public static Optional<Double> findAverage(int... nums){
        if (nums.length == 0)
            return Optional.empty();

        return Optional.of((double)IntStream.of(nums).sum() / nums.length);
    }

    public static void main(String[] args) {
        // empty() - creates instance with empty value
        Optional optionalEmpty = Optional.empty();
        OptionalLong optionalLong = OptionalLong.empty();

        // of(T) - creates instance with given value
        Optional optionalDate = Optional.of(LocalDate.now());
        OptionalInt optionalInt = OptionalInt.of(5);
        OptionalDouble optionalDouble = OptionalDouble.of(.5);
                
        // ofNullable(T) - equivalent to ternary operator and replace it 
        Object value = null;
        Optional obj1 = (value== null) ? Optional.empty(): Optional.of(value);
        Optional obj2 = Optional.ofNullable(value);
        
        System.out.println(Optional.of(null));			// throws NullPointerException
        System.out.println(Optional.ofNullable(null));	// Optional.empty 

        System.out.println(findAverage(10, 30));    // Optional[20.0]
        System.out.println(findAverage());          // Optional.empty

        Double avg1 = findAverage(10, 20).get();    // 20.0
        Double avg2 = findAverage().get();          // throws NoSuchElementException
        Double avg3 = findAverage().orElse(Double.NaN);  // to avoid this exception thrown      

        // boolean isPresent() 
        // checks if has value or not
        Optional<Double> emptyOptional = findAverage();
        if (emptyOptional.isPresent())
            System.out.println(emptyOptional.get());    // without check, it will throw NoSuchElementException

        // void ifPresent(Consumer<T>) 
        // It runs Consumer logic if value is present, otherwise won't run
        emptyOptional.ifPresent(System.out::println);   // no output

        System.out.println(emptyOptional.orElse(null));			// null
        System.out.println(emptyOptional.orElse(Double.NaN));	// Nan
        System.out.println(emptyOptional.orElseGet(() -> Math.random()));  // orElseGet takes double
        System.out.println(emptyOptional.orElseThrow(() -> new IllegalStateException()));   // using lambda
        System.out.println(emptyOptional.orElseThrow(IllegalStateException::new));          // method reference
    }
}
