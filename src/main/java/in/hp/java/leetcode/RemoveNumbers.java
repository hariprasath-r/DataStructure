package in.hp.java.leetcode;

public class RemoveNumbers {

    public static void main(String[] args) {
        System.out.println(removeMinDigit("5337", 2));
    }

    public static String removeKdigits(String num, int k) {

        if (num.length() <= k)
            return "0";

        int startIndex = 0;
        String sub1 = num.substring(startIndex, k);
        String rem1 = num.substring(k);

        int i = 1;
        int j = k + 1;
        while (j <= num.length()) {
            String sub2 = num.substring(i, j);
            String rem2 = rem2 = num.substring(0, i) + num.substring(j);

            if (Integer.parseInt(rem1) > Integer.parseInt(rem2)) {
                sub1 = sub2;
                rem1 = rem2;
                startIndex = i;
            }
            i++;
            j++;
        }

        String result = num.substring(0, startIndex) + num.substring(startIndex + k);

        return Integer.parseInt(result) + "";
    }

    public static String removeMinDigit(String num, int n) {
        if (num.length() <= n)
            return "0";

        StringBuilder sb = new StringBuilder(num);

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }
}
