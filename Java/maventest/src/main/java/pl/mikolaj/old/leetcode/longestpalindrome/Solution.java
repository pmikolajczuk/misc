package pl.mikolaj.old.leetcode.longestpalindrome;

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                if(isPalindrome(s, i, j)) {
                    if(j - i > result.length()) {
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int begin, int end) {
        for(int i = begin, j = end - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}