package in.hp.java.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeIssue {

    public static void main(String[] args) {

        String s = "2020-05-17 07:40:54";
        String format = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        LocalDateTime time = LocalDateTime.parse(s, dateTimeFormatter);
        System.out.println(time);

    }
}
