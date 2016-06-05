package datetimes.localization;

import java.util.ListResourceBundle;

/**
 * Resource bundle for App
 */
public class App_en extends ListResourceBundle {
    protected Object[][] getContents(){
        return new Object[][]{
            { "greeting", "Hello from Class" },
            { "departure", "Bye bye from Class" }
        };
    }
}
