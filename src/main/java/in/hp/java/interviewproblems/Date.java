package in.hp.java.interviewproblems;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Class represents date
 * Facilitates addition of days to the set date
 */
public class Date {

    final Map<Integer, Integer> monthDaysMap = new LinkedHashMap<>();
    private int d;
    private int m;
    private int y;
    private int d1;
    private int m1;
    private int y1;

    public Date() {
        populateMap();
    }

    public Date(int d, int m, int y) {
        this();
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public int getDay() {
        return d1;
    }

    public int getMonth() {
        return m1;
    }

    public int getYear() {
        return y1;
    }

    private void populateMap() {
        monthDaysMap.put(1, 31);
        monthDaysMap.put(2, 28);
        monthDaysMap.put(3, 31);
        monthDaysMap.put(4, 30);
        monthDaysMap.put(5, 31);
        monthDaysMap.put(6, 30);
        monthDaysMap.put(7, 31);
        monthDaysMap.put(8, 31);
        monthDaysMap.put(9, 30);
        monthDaysMap.put(10, 31);
        monthDaysMap.put(11, 30);
        monthDaysMap.put(12, 31);
    }

    /**
     * Accepts days to be added to the set date
     *
     * @param x
     * @return
     */
    Date plusDays(int x) {
        int offset1 = offSetDays();
        int remDaysInYear = isLeapYear(y) ? 366 - offset1 : 365 - offset1;

        int offset2 = 0;
        if (x < remDaysInYear) {
            y1 = y;
            offset2 = offset1 + x;
            findDayAndMonth(offset2, y1);
        } else {
            x -= remDaysInYear;
            y1 = y + 1;
            findYear(x);
        }
        return this;
    }

    private int offSetDays() {
        int offset = d;
        int i = 1;
        while (i <= 12) {
            if (i == m)
                break;
            offset += monthDaysMap.get(i);
            i++;
        }

        return isLeapYear(y) ? offset + 1 : offset;
    }

    private void findDayAndMonth(int offset, int y) {
        monthDaysMap.replace(2, isLeapYear(y) ? 29 : 28);

        int i = 1;
        while (offset > monthDaysMap.get(i)) {
            offset -= monthDaysMap.get(i);
            i++;
        }
        d1 = offset;
        m1 = i;
    }

    private void findYear(int x) {
        while (x > (isLeapYear(y1) ? 366 : 365)) {
            x -= isLeapYear(y1) ? 366 : 365;
            y1 = y1 + 1;
        }
        findDayAndMonth(x, y1);
    }

    /**
     * Method returns true if the given year is leapyear
     *
     * @param year
     * @return
     */
    public boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0 || year % 400 == 0);
    }
}

class Mainn {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Date Problem");
        Date date = new Date(30, 4, 1995);
        date.plusDays(2000);
        logger.info(date.getDay() + " " + date.getMonth() + " " + date.getYear());

        LocalDate today = LocalDate.of(1995, 4, 30);
        LocalDate newDay = today.plusDays(2000);
        logger.info(newDay.getDayOfMonth() + " " + newDay.getMonthValue() + " " + newDay.getYear());
    }
}