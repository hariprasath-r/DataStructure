package in.hp.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class OneSolution {

    public static void main(String[] args) {
//        bitwiseComplement(5);
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean result = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (magazine.contains("" + ransomNote.charAt(i))) {
                magazine = magazine.replaceFirst("" + ransomNote.charAt(i), "");
            } else {
                result = false;
            }
        }
        return result;
    }


    public static boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;

        final boolean[] result = {true};
        Map<Character, Integer> ransomCount = new HashMap<>();
        Map<Character, Integer> magazineCount = new HashMap<>();

        char[] chars1 = ransomNote.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (ransomCount.containsKey(chars1[i])) {
                ransomCount.put(chars1[i], ransomCount.get(chars1[i]) + 1);
            } else {
                ransomCount.put(chars1[i], 1);
            }
        }
        char[] chars2 = magazine.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (magazineCount.containsKey(chars2[i])) {
                magazineCount.put(chars2[i], magazineCount.get(chars2[i]) + 1);
            } else {
                magazineCount.put(chars2[i], 1);
            }
        }

        ransomCount.keySet().stream().parallel().forEach(c -> {
            if (magazineCount.getOrDefault(c, 0) < ransomCount.get(c))
                result[0] = false;
        });

        return result[0];
    }

    public static int bitwiseComplement(int n) {
        StringBuilder sb = new StringBuilder();
        int[] a = new int[32];
        int i = 0;

        while (n > 1) {
            a[i] = n % 2;
            n /= 2;
            i++;
        }
        a[i] = n;

        int x = i;
        for (int j = 0; j <= x; j++, i--) {
            sb.append(a[i] == 1 ? 0 : 1);
        }

        int result = Integer.parseInt(sb.toString(), 2);
        System.out.println(result);

        return 0;
    }

    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s : S.toCharArray()) // For each stone...
            for (char j : J.toCharArray()) // For each jewel...
                if (j == s) {  // If the stone is a jewel...
                    ans++;
                    break; // Stop searching whether this stone 's' is a jewel
                }
        return ans;
    }
}
