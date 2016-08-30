package datetimes.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * - java.text.NumberFormat
 * abstract class for formatting and parsing numbers in any locale
 * 
 * Below static methods return NumberFormat instances dedicated to different areas.
 * When no parameter, they choose default locale. They have additional overloaded 
 * versions which take Locale as a parameter: 
 * 	getNumberInstance() - general purpose number formatter
 * 	getIntegerInstance() - integer number formatter
 * 	getCurrencyInstance() - currency formatter
 * 	getPercentInstance() - percentage formatter
 *
 * String format(int|long) - format given number into String using chosen formatting
 * Number parse(String) - parse number from String using chosen formatting
 *
 * Note: Parsing continue until unknown character is found. If first character is unknown to chosen format
 * it throws checked exception java.text.ParseException
 *
 */
public class FormattingNumbers {
    public static void main(String[] args) throws ParseException{
        // 1. Formatting number

        // getNumberInstance() and getInstance() are same
        // getNumberInstance(Locale) and getInstance(Locale) are same
        NumberFormat numFormat = NumberFormat.getNumberInstance();
        NumberFormat numFormat_GER = NumberFormat.getNumberInstance(Locale.GERMANY);
        NumberFormat numFormat_FRA = NumberFormat.getNumberInstance(Locale.FRENCH);

        // String format(long|double) - returns formatted number
        double fractional = 1223.7123;
        System.out.println(numFormat.format(fractional));            // 1,223.712
        System.out.println(numFormat_GER.format(fractional));        // 1.223,712
        System.out.println(numFormat_FRA.format(fractional));        // 1 223,712

        // static NumberFormat getIntegerInstance() - creates formatter that rounds decimal value into integer
        // static NumberFormat getIntegerInstance(Locale) - does same using given locale
        NumberFormat numFormat_Integer = NumberFormat.getIntegerInstance();
        NumberFormat numFormat_Integer_UK = NumberFormat.getIntegerInstance(Locale.GERMANY);
        NumberFormat numFormat_Integer_FR = NumberFormat.getIntegerInstance(Locale.FRENCH);
        System.out.println(numFormat_Integer.format(fractional));           // 1,224
        System.out.println(numFormat_Integer_UK.format(fractional));        // 1.224
        System.out.println(numFormat_Integer_FR.format(fractional));        // 1 224

        // static NumberFormat getCurrencyInstance() - creates a formatter that displays currency
        // static NumberFormat getCurrencyInstance(Locale)
        double cost = 33;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat currencyFormat_UK = NumberFormat.getCurrencyInstance(Locale.UK);
        NumberFormat currencyFormat_JP = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println(currencyFormat.format(cost));                    // $33.00
        System.out.println(currencyFormat_UK.format(cost));                 // £33.00
        System.out.println(currencyFormat_JP.format(cost));                 // ￥3

        // static NumberFormat getPercentInstance() - creates percentage formatter
        // static NumberFormat getPercentInstance(Locale)
        double percentage = 95;
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        NumberFormat percentFormat_UK = NumberFormat.getPercentInstance(Locale.UK);
        System.out.println(percentFormat.format(percentage));               // 9,500%
        System.out.println(percentFormat_UK.format(percentage));            // 9,500%

        // 2. Parsing number

        // Number parse(String) - parse string into Number object using chosen formatting
        // parsing continues until unknown character and it throws checked exception
        // java.text.ParseException, when first character is unknown
        String number = "78.95";
        System.out.println(numFormat.parse(number));        // 78.95        . is decimal separator
        System.out.println(numFormat_GER.parse(number));    // 7895         . is 1000 separator
        System.out.println(numFormat_FRA.parse(number));    // 78           . is unknown in French

        String priceStr = "$7,880.22";
        double priceVal = (Double)currencyFormat.parse(priceStr);
        System.out.println(priceVal);                           // 7880.22
        System.out.println(currencyFormat_UK.parse(priceStr));  // ParseException, $ is unknown to UK

        String val1 = "93AJcK";
        String val2 = "-3.5ppJcK";
        String val3 = " 23AJcK";
        System.out.println(numFormat.parse(val1));      // 93
        System.out.println(numFormat.parse(val2));      // -3.5
        System.out.println(numFormat.parse(val3));      // ParseException
    }
}
