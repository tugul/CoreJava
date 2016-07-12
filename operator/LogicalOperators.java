package operator;

/**
 * && - logical AND, short-circuit
 * || - logical OR, short-circuit
 *  & - logical AND
 *  | - logical OR
 *  ^ - exclusive OR, XOR
 *
 * For short-circuit logical operators (&&, ||), only first operand is evaluated if its value determines outcome
 * For non short-circuit logical operators (&, |, ^), always both operands are evaluated
 *
 */
public class LogicalOperators {
    public static void main(String[] args) {
/*
        A ^ B (A != B)
        false ^ false = false
        false ^ true = true
        true ^ false = true
        true ^ true = false
*/
        System.out.println(true ^ false);  // true
        System.out.println(!true ^ false); // false

        int i, j = 0;
        i = true || (j++ == 0) ? 10 : 20;
        System.out.println(i + ", " + j);     // 10, 0

        i = true | (j++ == 0) ? 10 : 20;
        System.out.println(i + ", " + j);     // 10, 1
    }
}
