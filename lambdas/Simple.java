package lambdas;

import java.util.function.Predicate;

/**
 * Sample functional interface Climb is used in the example
 *
 */

interface Climb {
    boolean isTooHigh(int a, int b);
}
public class Simple {
    int value = 10;
    public static void main(String[] args) {
        check((h, p) -> h > p, 40);  // Too high
        check((h, p) -> h > 15, 10); // Ok

        test(new Simple(), simple -> simple.value > 20);   // Not
    }

    static void check(Climb climb, int c){
        if (climb.isTooHigh(c, 20))
            System.out.println("Too high");
        else
            System.out.println("Ok");
    }

    static void test(Simple s, Predicate<Simple> predicate)
    {
        if (predicate.test(s))
            System.out.println("Suits");
        else
            System.out.println("Not");
    }
}
