package in.hp.java.codewars;

/**
 * 5: Roman Numerals Encoder
 * https://www.codewars.com/kata/51b62bf6a9c58071c600001b/train/java
 */
public class Conversion {

    public String solution(int n) {
        String[] ones = new String[]{
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{
                "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{
                "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"", "M", "MM", "MMM"};

        return thousands[n / 1000]
                + hundreds[(n % 1000) / 100]
                + tens[(n % 100) / 10]
                + ones[n % 10];
    }
}