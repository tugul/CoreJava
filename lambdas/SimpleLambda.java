package lambdas;

import java.util.function.Predicate;

/**
 * Sample functional interface Climb is used in the example
 *
 */

interface Climb {
    boolean isTooHigh(int a, int b);
}

class Simple {
    int value = 18;

    static void test(Simple s, Predicate<Simple> predicate){
        if (predicate.test(s))
            System.out.println("Suits");
        else
            System.out.println("Not");
    }    
}

public class SimpleLambda {
    public static void main(String[] args) {
        check((x, y) -> x > y, 7);  // Too high (7 > 5)
        check((x, y) -> x > 9, 7);  // Ok       (7 > 9)

        Simple.test(new Simple(), s -> s.value > 10);   // Suits
        Simple.test(new Simple(), s -> s.value > 20);   // Not
    }

    static void check(Climb climb, int c){
        if (climb.isTooHigh(c, 5))
            System.out.println("Too high");
        else
            System.out.println("Ok");
    }
}
