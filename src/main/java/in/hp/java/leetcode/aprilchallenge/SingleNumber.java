package in.hp.java.leetcode.aprilchallenge;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
//        System.out.println(singleNumberBest(new int[]{1, 1, 2, 2, 3}));
        System.out.println(firstUniqChar(" "));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = nums[i];
            if (count.containsKey(result))
                count.replace(result, count.get(result) + 1);
            else
                count.put(result, 1);
        }

        return count.entrySet().stream().parallel()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey()).findAny().get();
    }

    public static int singleNumberBest(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;

        if (s.length() == 1)
            return 0;

        Map<Character, Integer> count = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        Character character = count.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(m -> m.getValue() == 1)
                .map(m -> m.getKey())
                .findFirst().orElse('\0');

        return character != '\0' ? s.indexOf(character) : -1;
    }
}
