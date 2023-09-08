package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatUtil {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss", Locale.getDefault());

    public static SimpleDateFormat dateFormat() {
        return simpleDateFormat;
    }
}
