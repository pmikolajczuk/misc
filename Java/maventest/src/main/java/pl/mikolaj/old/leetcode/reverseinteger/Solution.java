package pl.mikolaj.old.leetcode.reverseinteger;

public class Solution {
    public int reverse(int x) {
        String stringX = Integer.toString(Math.abs(x));
        String reversedStringX = reverseString(stringX);
        int reversedX;
        try{
            reversedX = Integer.valueOf(reversedStringX);
        }catch (NumberFormatException e) {
            return 0;
        }
        reversedX *= x < 0 ? -1 : 1;
        return reversedX;
    }

    private String reverseString(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(1534236469);
        System.out.println(result);
    }
}
