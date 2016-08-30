package exception;

/**
 * - Assertion
 * Boolean expression that allows to test any assumption of program at certain point
 * If boolean expression returns true, nothing happens and execution continues
 * If boolean expression returns false, it throws AssertionError with optional message if provided
 * By default, it is disabled and the line is ignored
 *
 * - Syntax
 * assert boolean_expression;
 * assert boolean_expression : optional_message;
 * boolean_expression can be optionally inside a bracket
 *
 * - Enable assertion
 * java -ea <class_name>
 * java -enableassertions <class_name>
 * java -ea:<package>... <class_name> // enable assertion for specific package and its subpackages
 * java -ea:<class_name> <class_name> // enable assertion for specific class only
 *
 * - Disable assertion
 * java -da <class_name>
 * java -disableassertions <class_name>
 *
 * Using selective enabling and disabling, assertion can be enabled for specific packages or classes only
 * It is not a good practice to change state of object or variable in assert statement
 *
 */
public class AboutAssertion {
    private String level;
    private void setLevel(int age){
        if (age > 60)
            level = "older";
        else if (age > 30)
            level = "middle-aged";
        else if (age > 0)
            level = "young";
    }

    public static void main(String[] args) {
        AboutAssertion a = new AboutAssertion();
        a.setLevel(10);
        assert (a.level != null);

        AboutAssertion b = new AboutAssertion();
        b.setLevel(-10);
        assert b.level != null : "Level must not be null";
    }
}
