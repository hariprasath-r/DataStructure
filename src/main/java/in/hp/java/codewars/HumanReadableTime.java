package in.hp.java.codewars;

import java.time.LocalTime;

public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(makeReadable(60));
    }

    public static String makeReadable(int seconds) {
        LocalTime localTime = LocalTime.ofSecondOfDay(seconds);
//        return localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond();

        int hh = 00;
        int mm = 00;
        int ss = seconds;
        if (seconds >= 60) {
            mm = seconds / 60;
            ss = seconds % 60;
            if (mm >= 60) {
                hh = mm / 60;
                mm %= 60;
            }
        }

        String h = hh < 10 ? "0" + hh : "" + hh;
        String m = mm < 10 ? ":0" + mm : ":" + mm;
        String s = ss < 10 ? ":0" + ss : ":" + ss;

        return h + m + s;
    }
}
