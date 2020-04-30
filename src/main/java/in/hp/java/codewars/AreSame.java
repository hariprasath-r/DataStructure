package in.hp.java.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 2. Are they the "same"?
 * https://www.codewars.com/kata/550498447451fbbd7600041c/train/java
 */
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (!(Objects.nonNull(a) && Objects.nonNull(b))
                || (a.length != b.length))
            return false;

        if (a.length == 0 && b.length == 0)
            return true;

        List<Integer> arr1 = Arrays.stream(a)
                .map(x -> x * x)
                .sorted()
                .boxed().collect(Collectors.toList());

        List<Integer> arr2 = Arrays.stream(b)
                .sorted()
                .boxed().collect(Collectors.toList());

        System.out.println(arr1);
        System.out.println(arr2);

        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i).intValue() != arr2.get(i).intValue())
                return false;
        }
        return true;
    }

    public boolean compBestSolution(int[] a, int[] b) {
        return a != null && b != null
                && a.length == b.length
                && Arrays.equals(Arrays.stream(a).sorted().map(x -> x * x).toArray(),
                Arrays.stream(b).sorted().toArray());
    }
}
