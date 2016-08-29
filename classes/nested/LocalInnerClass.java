package classes.nested;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * - Local inner class 
 * Is defined within any block of method body.
 * Has no access modifier, its members can have any access modifier
 * Only exists when enclosing method is invoked
 * Can't be static or can't have static members
 * Can access to all members of outer class
 * Can access to only final or effectively final local member of a enclosing method
 */
public class LocalInnerClass {
    String postCodeRegex = "";
    

    void ValidatePostCode(String postCode){
        String wordIs = " are ";
        // reassigned, so no longer effective final and can't be accessed from local inner class
        wordIs = " is ";		

        class PostCode implements Serializable {
            Pattern pattern = Pattern.compile(postCodeRegex);	// not effectively final, but not local, so can be accessed
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
        innerClassObj.postCodeRegex = "^[0-9]{3}(\\s|-)?[0-9]{2}$";
        
        innerClassObj.ValidatePostCode("344-56");   // true
        innerClassObj.ValidatePostCode("344 56");   // true
        innerClassObj.ValidatePostCode("34456");    // true
        innerClassObj.ValidatePostCode("344  56");  // false
    }
}

//344-56 is true
//344 56 is true
//34456 is true
//344  56 is false
