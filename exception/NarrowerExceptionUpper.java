package exception;

/**
 * It doesn't compile because
 * For inherited exceptions, narrower type must place in former
 * As MisMatchedColor is child class of MisMatched
 * so, it must be before MisMatched catch
 */

class MisMatched extends RuntimeException {}
class MisMatchedColor extends MisMatched {}

public class NarrowerExceptionUpper {
    static void meet(){}

    public static void main(String[] args) {
        try {
            meet();
        }
        catch (MisMatched e){
            System.out.println("Come back later");
        }
        catch (MisMatchedColor e){ // DOES NOT COMPILE
            System.out.println("Come back after lunch");
        }


    }

}
