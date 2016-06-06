package datetimes.localization;

import java.util.Locale;

/**
 * - Locale
 * represents specific geographical, political, or cultural region. (number format, date format etc.)
 *
 * i18n - internationalization
 * l10n - localization
 *
 * - Locale string format lc_CC
 * lc - lowercase language code, mandatory part
 * CC - uppercase country code, optional together with _
 */
public class UsingLocale {
    public static void main(String[] args) {
        // 1. Get default locale in Java
        Locale locale = Locale.getDefault();
        System.out.println(locale);                     // en_US

        // 2. Get specific locale
        System.out.println(Locale.KOREAN);              // ko       language
        System.out.println(Locale.KOREA);               // ko_KR    with country

        // 3. Create locale with constructor(Java doesn't validate)
        System.out.println(new Locale("sv"));           // sv       language
        System.out.println(new Locale("sv", "SE"));     // sv_SE    with country

        // 4. Use builder pattern to create Locale (set all properties, then build)
        Locale swedishLC = new Locale.Builder()
                .setLanguage("sv")
                .setRegion("SE")
                .build();
        System.out.println(swedishLC);                      // sv_SE

        // Set default locale
        Locale.setDefault(swedishLC);
        System.out.println(Locale.getDefault());            // sv_SE
    }
}
