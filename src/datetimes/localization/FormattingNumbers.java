package datetimes.localization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * - java.text.NumberFormat
 * abstract base class for formatting and parsing numbers in any locale
 *
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        // Getting number format, below 2 methods do exactly same
        // getNumberInstance()
        // getInstance()
        Locale us = Locale.US;

        NumberFormat numFormat_default = NumberFormat.getNumberInstance();
        NumberFormat numFormat_us_ = NumberFormat.getIntegerInstance(us);

        double fractional = 223.7123;

        System.out.println(numFormat_default.format(fractional));
        System.out.println(numFormat_us.format(fractional));




    }
}
