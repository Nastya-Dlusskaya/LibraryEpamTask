package by.epam.library.util;

import java.util.Calendar;
import java.util.Date;

public class CalenderCalculator {

    public static Date calculatePlannedDate(String type) {
        Date now = new Date( );
        Calendar calendar = Calendar.getInstance( );
        calendar.setTime(now);
        switch(type){
            case "HOME":
                calendar.add(Calendar.MONTH, 1);
                break;
            case "HALL":
                calendar.add(Calendar.HOUR_OF_DAY, 3);
                break;
            case "ORDER_BOOK":
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                break;
            default:
        }
        return calendar.getTime( );
    }

    public static Date calculateCurrentDate() {
        return new Date();
    }
}
