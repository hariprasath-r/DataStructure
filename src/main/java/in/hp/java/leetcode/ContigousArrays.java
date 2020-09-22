package in.hp.java.leetcode;

import java.util.HashMap;

public class ContigousArrays {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0}));
    }

    public static int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        HashMap<Integer, Integer> hMap = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);

            if (sum == 0) {
                maxLength = i + 1;
            }

            if (hMap.containsKey(sum + n)) {
                if (maxLength < i - hMap.get(sum + n)) {
                    maxLength = i - hMap.get(sum + n);
                }
            } else {
                hMap.put(sum + n, i);
            }
        }
        return maxLength;
    }
}
