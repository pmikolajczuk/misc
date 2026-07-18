package pl.mikolaj.old.leetcode.longestsubstring;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> characters = new HashSet<>();
            int count = 0;
            for(int j = i; j < s.length(); j++) {
                Character c = s.charAt(j);
                if(characters.contains(c)) {
                    break;
                }
                characters.add(c);
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}