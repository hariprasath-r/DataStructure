package in.hp.java.codewars;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean isIsogram(String str) {
        Set<Character> set = new HashSet<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return str.length() == set.size();
    }

    public static boolean isIsogramBestPractise(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
