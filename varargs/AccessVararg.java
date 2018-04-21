package varargs;

/**
 * Like an array, varargs uses index
 */
public class AccessVararg {
    void printValue(int index, int ... numbers){
        System.out.println(numbers[index]);
    }

    public static void main(String[] args) {
        new AccessVararg().printValue(1, 4, 5, 6); // Prints 5 which is at index 1
    }
}
