package pl.mikolaj.r2025.leetcode.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;

		for (int start = 0; start < s.length(); start++) {
			Set<Character> chars = new HashSet<>();
			int currentLength = 0;
			for (int end = start; end < s.length(); end++) {
				Character nextChar = s.charAt(end);
				if (chars.contains(nextChar)) {
					break;
				} else {
					chars.add(nextChar);
					currentLength++;
				}
			}
			maxLength = Math.max(maxLength, currentLength);
		}
		return maxLength;
	}
}
