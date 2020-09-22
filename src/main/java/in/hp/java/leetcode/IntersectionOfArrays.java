package in.hp.java.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        System.out.println(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int[] tempA = A[A.length - 1];
        int[] tempB = B[B.length - 1];

        int lastElementInA = tempA[tempA.length - 1];
        int lastElementInB = tempB[tempB.length - 1];
//        int flatArrayLength = lastElementInA > lastElementInB ? lastElementInA : lastElementInB;

        int[] flatArrA = new int[lastElementInA + 1];

        for (int i = 0; i < A.length; i++) {
            int[] temp = A[i];
            Arrays.fill(flatArrA, temp[0], temp[temp.length - 1], 1);
        }

        int[] flatArrB = new int[lastElementInB + 1];
        for (int i = 0; i < B.length; i++) {
            int[] temp = B[i];
            Arrays.fill(flatArrB, temp[0], temp[temp.length - 1], 1);
        }

        int flatArrayLength = flatArrA.length < flatArrB.length ? flatArrA.length : flatArrB.length;
        List<List<Integer>> resultList = new ArrayList<>();
        List<int[]> results = new ArrayList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < flatArrayLength; i++) {
            if (flatArrA[i] == 1 && flatArrB[i] == 1 && start == -1) {
                start = i;
            } else if (flatArrA[i] != flatArrB[i] && start > -1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(i);
                resultList.add(temp);

                int[] temp1 = new int[2];
                temp1[0] = start;
                temp1[1] = i;
                results.add(temp1);

                start = -1;
            }
        }

        int[][] resultArr = new int[results.size()][];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = results.get(i);
        }

        return resultArr;
    }

}
