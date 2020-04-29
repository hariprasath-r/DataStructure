package in.hp.java.interviewproblems;

public class InfiniteString {
    public static void main(String[] args) {
        System.out.println(findOccurances("abc", 9));
    }

    static int findOccurances(String s, int n) {
        StringBuilder sb = new StringBuilder();

        while (sb.length() < n) {
            sb.append(s);
        }

        int result = 0;
        String sub = sb.toString().substring(0, n);
        for (int j = 0; j < sub.length(); j++) {
            if (sub.charAt(j) == 'a')
                result++;
        }

        return result;
    }
}
