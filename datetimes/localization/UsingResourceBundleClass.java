package datetimes.localization;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * - Java class for resource bundle
 * allows any Java type in value as Property file for resource bundle allows only String in value
 * can create values of properties at the runtime
 * Key is String
 * must inherit abstract class ListResourceBundle
 *
 *
 */
class Vocabulary_en_US extends ListResourceBundle{
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"behaviour", "behaviour"},
            {"colour", "colour"}
        };
    }
}

class Vocabulary_en_UK extends ListResourceBundle{
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"behaviour", "behavior"},
            {"colour", "color"}
        };
    }
}

public class UsingResourceBundleClass {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Vocabulary", locale);

        System.out.println(rb.getString("behaviour"));      // behaviour
        System.out.println(rb.getString("colour"));         // colour
    }
}
