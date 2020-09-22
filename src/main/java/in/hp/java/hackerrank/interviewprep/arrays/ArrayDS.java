package in.hp.java.hackerrank.interviewprep.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class ArrayDS {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        if (a.length == d) {
            return a;
        }

        List<Integer> b = new ArrayList<>();
        for (int i = d; i < a.length; i++) {
            b.add(a[i]);
        }

        for (int i = 0; i < d; i++) {
            b.add(a[i]);
        }

        for (int i = 0; i < b.size(); i++) {
            a[i] = b.get(i);
        }
        return a;
    }

    static int hourglassSum(int[][] arr) {
        int sum = 0;
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = 0;
                for (int k = i, l = j; k <= (i + 2); k++) {
                    if (k != (i + 1))
                        sum += arr[k][j] + arr[k][j + 1] + arr[k][j + 2];
                    else
                        sum += arr[k][j + 1];
                }
                sums.add(sum);
            }
        }

        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(0);
    }
}
