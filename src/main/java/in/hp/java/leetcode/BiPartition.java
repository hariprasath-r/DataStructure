package in.hp.java.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BiPartition {

    public static void main(String[] args) {
        possibleBipartition1(50, new int[][]{{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}});
    }

    public static boolean possibleBipartition1(int N, int[][] dislikes) {
        if (N == 0) return false;
        if (N == 1) return true;
        if (dislikes.length < 1) return false;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < dislikes.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(dislikes[i][0]);
            temp.add(dislikes[i][1]);
            lists.add(temp);
        }

        List<List<Integer>> sortedList = mergeSort(lists);

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < dislikes.length; i++) {
            List<Integer> temp = sortedList.get(i);
            int a = temp.get(0);
            int b = temp.get(1);

            boolean addedToA = true;
            if (setA.contains(a)) {
                if (!setA.contains(b))
                    setA.add(a);
                else return false;
            } else if (setB.contains(a)) {
                if (!setB.contains(b)) {
                    setB.add(a);
                    addedToA = false;
                } else return false;
            } else if (!setA.contains(b)) {
                setA.add(a);
            } else {
                setB.add(a);
                addedToA = false;
            }

            if (addedToA) {
                if (!setB.contains(a))
                    setB.add(b);
                else
                    return false;
            } else if (!setA.contains(a)) {
                setA.add(b);
            } else {
                return false;
            }

        }
        return true;
    }

    private static List<List<Integer>> mergeSort(List<List<Integer>> list) {
        if (list.size() <= 1) return list;
        int mid = list.size() / 2;
        List<List<Integer>> left = mergeSort(list.subList(0, mid));
        List<List<Integer>> right = mergeSort(list.subList(mid + 1, list.size()));
        return mergeArrays(left, right);
    }

    private static List<List<Integer>> mergeArrays(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).get(0) < b.get(j).get(0)) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }
        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }
        return result;
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {

        if (N == 0) return false;
        if (N == 1) return true;
        if (dislikes.length < 1) return false;

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int tempa = dislikes[0][0];
        int tempb = dislikes[0][1];

        if (tempa > tempb || tempa == tempb) return false;

        setA.add(tempa);
        setB.add(tempb);

        for (int i = 1; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];

            if (a > b || a == b) return false;
            boolean addedToA = true;
            if (setA.contains(a)) {
                if (!setA.contains(b))
                    setA.add(a);
                else return false;
            } else if (setB.contains(a)) {
                if (!setB.contains(b)) {
                    setB.add(a);
                    addedToA = false;
                } else return false;
            } else if (!setA.contains(b)) {
                setA.add(a);
            } else {
                setB.add(a);
                addedToA = false;
            }

            if (addedToA) {
                if (!setB.contains(a))
                    setB.add(b);
                else
                    return false;
            } else if (!setA.contains(a)) {
                setA.add(b);
            } else {
                return false;
            }
        }

        return true;
    }
}
