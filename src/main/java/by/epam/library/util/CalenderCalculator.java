package by.epam.library.util;

import java.util.Calendar;
import java.util.Date;

public class CalenderCalculator {

    public static Date calculatePlannedReturnDate(String type) {
        Date now = new Date( );
        Calendar calendar = Calendar.getInstance( );
        calendar.setTime(now);
        if (type.equals("HOME")) {
            calendar.add(Calendar.MONTH, 1);
        } else {
            calendar.add(Calendar.HOUR_OF_DAY, 3);
        }
        return calendar.getTime( );
    }

    public static Date calculateCurrentDate() {
        return new Date();
    }
}
