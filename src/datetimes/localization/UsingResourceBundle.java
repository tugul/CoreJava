package datetimes.localization;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * - Resource bundle
 * Contains locale specific objects (key value pair) to be used by program
 * program will be independent from users' locales/language and highly maintainable
 * It can be defined in property file or in a class.
 *
 * - Priority of locating a resource
 * 1. Java class is always sought before property file
 * 2. Look for given language and country code
 * 3. if not found, look for default language and country
 * 4. if not found, look for just resource name
 * Below are top-down order
 * XXX_sv_SE.java
 * XXX_sv_SE.properties
 * XXX_sv.java
 * XXX_sv.properties
 * XXX_en_US.java
 * XXX_en_US.properties
 * XXX_en.java
 * XXX_en.properties
 * XXX.java
 * XXX.properties
 * if not found in order, throws MissingResourceException
 *
 */
public class UsingResourceBundle {
    public static void main(String[] args) {

        /* Variable inside property file
        example resource is defined in App.properties

        greetWithName=Hello, {0}

        */

        ResourceBundle rb = ResourceBundle.getBundle("App");
        String stringFormat = rb.getString("greetWithName");
        String formatted = MessageFormat.format(stringFormat, "Daisy");
        System.out.print(formatted);    // Hello, Daisy
    }
}
