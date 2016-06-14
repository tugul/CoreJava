package classes.nested;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Local inner class is defined within any block of method body.
 * - has no access modifier
 * - only exists when enclosing method is invoked
 * - can't be static or can't have static members, its members can have any access modifier
 * - can access to all members of outer class
 * - can access to only final or effectively final member of enclosing method
 */
public class LocalInnerClass {
    String postCodeRegex = "^[0-9]{3}(\\s|-)?[0-9]{2}$";

    void ValidatePostCode(String postCode){
        String wordIs = " are ";
        wordIs = " is ";

        class PostCode implements Serializable {
            Pattern pattern = Pattern.compile(postCodeRegex);
            String postCode;
            public PostCode(String postCode) {
                this.postCode = postCode;
            }

            public boolean isValid(){
                return pattern.matcher(postCode).matches();
            }

            private String getPostCode() { return postCode; }
        }

        PostCode validatedCode = new PostCode(postCode);
        System.out.println(validatedCode.getPostCode() + wordIs +validatedCode.isValid());
    }

    public static void main(String[] args) {
        LocalInnerClass innerClassObj = new LocalInnerClass();
        innerClassObj.ValidatePostCode("344-56");   // true
        innerClassObj.ValidatePostCode("344 56");   // true
        innerClassObj.ValidatePostCode("34456");    // true
        innerClassObj.ValidatePostCode("344  56");  // false
    }
}
