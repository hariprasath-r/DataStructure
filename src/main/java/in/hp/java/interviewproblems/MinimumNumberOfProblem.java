package in.hp.java.interviewproblems;

import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfProblem {
    public static void main(String[] args) {
        List<Integer> points = Arrays.asList(1,2,3,4,5);
        int threshold = 4;
        System.out.println("Minimum Number of Problems to solve: "
                + MinimumNumberOfProblem.minNum(threshold, points));
    }

    public static int minNum(int threshold, List<Integer> points) {
        int minimumPoint = points.get(0);
        int maxPointIndex = -1;
        int result = 0;

        if (threshold == minimumPoint)
            return 1;

        int j = 0;
        while (j < points.size() && maxPointIndex < 0) {
            if (points.get(j) - minimumPoint >= threshold) {
                maxPointIndex = j;
            }
            j++;
        }

        if (maxPointIndex < 0) {
            return points.size();
        }

        for (int i = 0; i <= maxPointIndex; i++) {
            if (i + 2 <= maxPointIndex) {
                i++;
            }
            result++;
        }

        return result;
    }
}
