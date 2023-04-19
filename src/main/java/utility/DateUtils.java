package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getCurrentTime() {
        return new SimpleDateFormat().format(new Date());
    }

}
