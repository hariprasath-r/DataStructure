package in.hp.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortCharByFrequency {

    public static void main(String[] args) {
        // caaccbdaef - aaaccc
        System.out.println(frequencySort("caBBaccbdAaeAfAE"));
    }

    public static String frequencySort(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

//        map.getOrDefault()

        StringBuilder sb = new StringBuilder();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(mapEntry -> {
                    char[] c = new char[mapEntry.getValue()];
                    Arrays.fill(c, mapEntry.getKey());
                    sb.append(c);
                });

        return sb.reverse().toString();
    }
}
