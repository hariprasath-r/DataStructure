package in.hp.java.codewars;

import java.util.stream.DoubleStream;

/**
 * 4. BitCounting
 * https://www.codewars.com/kata/526571aae218b8ee490006f4/solutions/java
 */
public class BitCounting {
    public static int countBits(int n){
        int i = 0;
        while (n > 0) {
            if (n % 2 == 1)
                i++;
            n /= 2;
        }
        return i;
    }

    public static int countBitsBestSolution(int n) {
        return Integer.bitCount(n);
    }
}
