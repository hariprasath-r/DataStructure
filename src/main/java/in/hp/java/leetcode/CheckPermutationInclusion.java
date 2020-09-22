package in.hp.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutationInclusion {
    public static void main(String[] args) {

        // adc, dcda
        System.out.println(checkInclusion2("adc",
                "dcda"));
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() >= 10000 || s2.length() >= 10000) return false;
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s1.length() > s2.length()) return false;

        char[] s1Chars = new char[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Chars[c - 'a']++;
        }

        char[] s2Chars = new char[26];

        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char start = s2.charAt(left);
            char c = s2.charAt(right);
            int subStringLength = right - left + 1;

            s2Chars[c - 'a']++;

            if (subStringLength < s1.length()) {
                right++;
                continue;
            }

            if (Arrays.equals(s1Chars, s2Chars)) return true;

            s2Chars[start - 'a']--;
            left++;
            right++;
        }

        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Arr = new int[26];
        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int left = 0, right = 0;
        int[] s2Arr = new int[26];
        while (right < s2.length()) {
            char start = s2.charAt(left);
            char c = s2.charAt(right);
            int len = right - left + 1;
            s2Arr[c - 'a']++;

            if (len < s1.length()) {
                right++;
                continue;
            }
            //Compare if two arrays are equal
            if (Arrays.equals(s1Arr, s2Arr)) {
                return true;
            }
            //Slide the window by ONE, minus one on original start char
            s2Arr[start - 'a']--;
            left++;
            right++;
        }
        return false;
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() >= 10000 || s2.length() >= 10000) return false;
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s1.length() > s2.length()) return false;

        boolean result = false;

        HashMap<Character, Integer> s1Table = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s1Table.containsKey(c)) {
                s1Table.put(c, s1Table.get(c) + 1);
            } else {
                s1Table.put(c, 1);
            }
        }

        HashMap<Character, Integer> s2Table = new HashMap<>();
        for (int i = 0, count = 0, check = s1.length(); i < s2.length(); i++) {
//            if (count >= check) break;
            char c = s2.charAt(i);
            if (s1Table.containsKey(c)) {
                count++;
                if (s2Table.containsKey(c)) {
                    s2Table.put(c, s2Table.get(c) + 1);
                } else {
                    s2Table.put(c, 1);
                }
            } else {
                count = 0;
//                s2Table.clear();
            }
        }

        if (s1Table.size() > s2Table.size()) return false;

        long count = s2Table.entrySet().stream()
                .filter(entry -> s1Table.containsKey(entry.getKey())
                        && s1Table.get(entry.getKey()) <= entry.getValue())
                .count();

        if (count == s1.length()) return true;

//        if (s1Table.equals(s2Table))
//            return true;

        return result;
    }
}
