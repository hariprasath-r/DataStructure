package in.hp.java.leetcode;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483644));
    }

    public static boolean isPerfectSquare(int num) {
//        int x = isSqr(0, num, num);
//        return x * x == num;

        // base case
        // return true for 1
        // return false for 0 or less than 4
        if (num == 1)
            return true;
        if (num < 4)
            return false;

        int r = num;
        int i = 0;
        long mid = 0;
        long midSqr = 0;
        while (i <= num) {
            mid = (i + num) / 2;
            midSqr = mid * mid;
            if (midSqr == r) {
                return true;
            }
            if (midSqr > r) {
                num = (int) mid - 1;
            } else {
                i = (int) mid + 1;
            }
        }
        return false;
    }

    static int isSqr(int low, int high, int n) {
        int mid = (low + high) / 2;
        if (mid * mid <= n && (mid + 1) * (mid + 1) > n)
            return mid;
        else if (mid * mid > n)
            return isSqr(low, mid - 1, n);
        else
            return isSqr(mid + 1, high, n);
    }
}
