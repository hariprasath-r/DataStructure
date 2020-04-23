package in.hp.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemovingConsecutiveStrings {
    public static void main(String[] args) {
        String s = "wwwbbbwwwbbbwwwbb";
        System.out.println("Winner :: " + removeConsecutiveStrings(s, "w", "b", 3));
    }

    static String removeConsecutiveStrings(String s, String s1, String s2, int lengthToSearch) {
        Pattern p1 = Pattern.compile("[" + s1 + "]{" + lengthToSearch + "}");
        Pattern p2 = Pattern.compile("[" + s2 + "]{" + lengthToSearch + "}");
        Matcher m1 = p1.matcher(s);
        Matcher m2 = p2.matcher(s);

        boolean isS1Present = m1.find();
        boolean isS2Present = m2.find();

        if (!isS1Present && !isS2Present)
            return s1;
        if (!isS1Present)
            return s2;
        else if (!isS2Present)
            return s1;

        m1.reset();
        m2.reset();

        int s1MatchCount = 0;
        while (m1.find())
            s1MatchCount++;

        int s2MatchCount = 0;
        while (m2.find())
            s2MatchCount++;

        return s1MatchCount - s2MatchCount > 0 ? s1 : s2;
    }
}
