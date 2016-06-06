package datetimes.localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * - Resource files
 * It must exist in class path. Example files:
 * App_en.properties
 * App_de.properties
 * App_sv.properties
 *
 * - Properties file format
 * Key value separators can be =, : or space
 * Comments starts with #, !
 * Spaces before or after separator are ignored
 * Spaces in the beginning of a line are ignored
 * Escape characters can be used \n, \t
 * Line break character is \
 *
 * - Properties class
 * inherits HashTable and created before Map
 * represents a persistent set of properties
 *
 */
public class UsingResourceBundleFile {
    static void printProperties(Locale locale, String word)
    {
        // getBundle(String, Locale) - baseName is string
        ResourceBundle rb = ResourceBundle.getBundle("App", locale);
        if (rb.containsKey(word))
            System.out.println(rb.getString(word));
        else
            System.out.println("Key not found: " + word);
    }

    public static void main(String[] args) {
        Locale en = new Locale("en", "EN");
        Locale de = new Locale("de", "DE");
        Locale sv = new Locale("sv", "SE");

        printProperties(en, "greeting");    // Hello
        printProperties(de, "greeting");    // Hallo
        printProperties(sv, "greeting");    // Hej hej
        printProperties(de, "departure");
        printProperties(sv, "departure");

        // Uses Properties class to get property values via its key
        Properties properties = new Properties();

        // getBundle(String) - get bundle using default locale
        // getBundle(String, Locale) - get bundle using given locale
        ResourceBundle rb = ResourceBundle.getBundle("App");
        rb.keySet().stream().forEach(x -> properties.put(x, rb.getString(x)));

        // get(String) - returns value of given key
        // getProperty(String) - returns value of given key
        // getProperty(String, String) - second arg is default value to be used if key not found
        System.out.println(properties.getProperty("greeting"));                 // Hello
        System.out.println(properties.getProperty("notFound"));                 // null
        System.out.println(properties.getProperty("notFound", "defaulValue"));  // defaulValue
        System.out.println(properties.get("greeting"));                         // Hello
        System.out.println(properties.get("notfound"));                         // null,
    }
}
