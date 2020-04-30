package in.hp.java.interviewproblems;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void test1() {
        int d = 30;
        int m = 4;
        int y = 1995;
        int daysToAdd = 116;
        Date date = new Date(d, m, y).plusDays(daysToAdd);
        LocalDate date1 = LocalDate.of(y, m, d).plusDays(daysToAdd);
        assertEquals(date1.getDayOfMonth(), date.getDay());
        assertEquals(date1.getMonthValue(), date.getMonth());
        assertEquals(date1.getYear(), date.getYear());
    }

    @Test
    public void test2() {
        int d = 24;
        int m = 8;
        int y = 1995;
        int daysToAdd = 2000;
        Date date = new Date(d, m, y).plusDays(daysToAdd);
        LocalDate date1 = LocalDate.of(y, m, d).plusDays(daysToAdd);
        assertEquals(date1.getDayOfMonth(), date.getDay());
        assertEquals(date1.getMonthValue(), date.getMonth());
        assertEquals(date1.getYear(), date.getYear());
    }

    @Test
    public void test3() {
        int d = 30;
        int m = 4;
        int y = 2020;
        int daysToAdd = 4000;
        Date date = new Date(d, m, y).plusDays(daysToAdd);
        LocalDate date1 = LocalDate.of(y, m, d).plusDays(daysToAdd);
        assertEquals(date1.getDayOfMonth(), date.getDay());
        assertEquals(date1.getMonthValue(), date.getMonth());
        assertEquals(date1.getYear(), date.getYear());
    }

}