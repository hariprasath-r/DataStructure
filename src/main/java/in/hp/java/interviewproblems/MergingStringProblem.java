package in.hp.java.interviewproblems;

public class MergingStringProblem {
    public static void main(String[] args) {
        System.out.println("Merged String :: " + mergeStringsAlternatively("hari", "prasath "));
    }

    static String mergeStringsAlternatively(String a, String b) {

        if (a.isEmpty() || b.isEmpty()) {
            return a + b;
        }

        StringBuilder mergedString = new StringBuilder();
        String tailString = "";
        int aLength = a.length();
        int bLength = b.length();
        int loopLength = a.length();

        int diff = aLength - bLength;

        if (diff > 0) {
            loopLength = bLength;
            tailString = a.substring(bLength);
        } else if (diff < 0) {
            tailString = b.substring(aLength);
        }

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        for (int i = 0; i < loopLength; i++) {
            mergedString.append(arr1[i]).append(arr2[i]);
        }

        if (!tailString.isEmpty())
            mergedString.append(tailString);

        return mergedString.toString();
    }
}
