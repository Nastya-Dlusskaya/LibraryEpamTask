package by.epam.library.util;

import java.util.Calendar;
import java.util.Date;

public class CalenderCalculator {

    private static final String HOME = "HOME";
    private static final String HALL = "HALL";
    private static final String PUT_ASIDE_BOOK = "PUT_ASIDE_BOOK";
    private static final int COUNT_DAY_FOR_HOME = 1;
    private static final int COUNT_HOUR_FOR_HALL = 3;
    private static final int COUNT_DAY_FOR_PUT_ASIDE = 1;

    public static Date calculatePlannedDate(String type) {
        Date now = new Date( );
        Calendar calendar = Calendar.getInstance( );
        calendar.setTime(now);
        switch(type){
            case HOME:
                calendar.add(Calendar.MONTH, COUNT_DAY_FOR_HOME);
                break;
            case HALL:
                calendar.add(Calendar.HOUR_OF_DAY, COUNT_HOUR_FOR_HALL);
                break;
            case PUT_ASIDE_BOOK:
                calendar.add(Calendar.DAY_OF_MONTH, COUNT_DAY_FOR_PUT_ASIDE);
                break;
            default:
        }
        return calendar.getTime( );
    }

    public static Date calculateCurrentDate() {
        return new Date();
    }
}
