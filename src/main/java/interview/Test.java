package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        System.out.println(Test.minStart(Arrays.asList(-5, 4 - 2, 3, 1, -1, -6, -1, 0, 5)));

        System.out.println(autumnLeaves(Arrays.asList(10,20,30), 20, Arrays.asList(2,3), Arrays.asList(2,3), Arrays.asList(3,3)));
    }

    public static List<Long> autumnLeaves(List<Integer> leaves, int percentage, List<Integer> day, List<Integer> starting, List<Integer> ending) {
        List<Long> result = new ArrayList<>();

        if (leaves.size() == 0 || day.size() == 0 || starting.size() == 0 || ending.size() == 0) {
            return result;
        }

        for (int l = 0; l < day.size(); l++) {
            int i = starting.get(l);
            int j = ending.get(l);

            if (i < 0 || i > leaves.size() || j < 0 || j > leaves.size()) {
                result.add(Long.MIN_VALUE);
                break;
            }

            long sum = 0;
            for (int k = i - 1; k < j; k++) {
                int leavesInDay = leaves.get(k);
                for (int m = 0; m < day.get(l); m++) {
                    if (leavesInDay > 0) {
                        long temp = calculatePercentage(percentage, leavesInDay);
                        leavesInDay -= temp;
                        sum += temp;
                    } else break;
                }
            }
            result.add(sum);
        }

        return result;
    }

    private static long calculatePercentage(int percentage, int value) {

        return (long) Math.floor((percentage* value)/ 100);
    }

    public static long minStart(List<Integer> arr) {
        if (arr.size() <= 0) return 0;

        int lowest = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > lowest)
                lowest = arr.get(i);
        }

        long x = lowest + 1;
        while (true) {
            long runningSum = x;
            boolean stillLow = false;
            for (int i = 0; i < arr.size(); i++) {
                runningSum = runningSum + arr.get(i);
                if (runningSum < 1)
                    stillLow = true;
            }
            if (stillLow) {
                x++;
            } else break;
        }

        return x;
    }
}
