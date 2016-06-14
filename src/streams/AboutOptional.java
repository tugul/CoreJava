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
 * introduced in Java 8 to reduce null pointer exceptions
 * container type wrapping a single primitive or object which might be absent or present
 * more expressive than null, so supports functional programming style
 *
 * - Caller of method returning Optional
 * should use ifPresent to check value is present or not
 * get() - returns the value or it throws NoSuchElementException if empty
 * isPresent() - check if value is present or not
 * ifPresent(Consumer<T>) - call Consumer parameter if value is present
 *
 * - To deal with absent case / if value in Optional is absent
 * orElse(T) - returns given parameter value
 * orElseGet(Supplier<T>) - returns result of Supplier
 * orElseThrow(Supplier<Throwable>) - throws exception
 * ofNullable(T) - creates optional with given value, but if value is null, it creates with empty
 *
 * - Primitive Optional classes with their method specific to their types
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

        System.out.println(findAverage(10, 30));    // Optional[20.0]
        System.out.println(findAverage());          // Optional.empty

        Double avg1 = findAverage(10, 20).get();    // 20.0
        //Double avg2 = findAverage().get();          // NoSuchElementException

        // isPresent() - check if has value or not
        Optional<Double> emptyOptional = findAverage();
        if (emptyOptional.isPresent())
            System.out.println(emptyOptional.get());    // without check, it will throw NoSuchElementException

        // ifPresent(Consumer<T>) - call Consumer parameter if there is value present, otherwise won't call
        emptyOptional.ifPresent(System.out::println);   // no result

        System.out.println(emptyOptional.orElse(Double.NaN));
        System.out.println(emptyOptional.orElseGet(() -> Math.random()));  // orElseGet takes double
        System.out.println(emptyOptional.orElseThrow(() -> new IllegalStateException()));      // using lambda
        System.out.println(emptyOptional.orElseThrow(IllegalStateException::new));             // method reference

        // ofNullable(T)
        // Ternary operator to avoid null can be replaced with Optional.ofNullable(...)
        Object value = null;
        Optional obj1 = (value== null) ? Optional.empty(): Optional.of(value);
        Optional obj2 = Optional.ofNullable(value);
    }
}
