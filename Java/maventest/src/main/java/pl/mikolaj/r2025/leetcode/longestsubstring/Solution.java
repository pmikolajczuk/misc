package pl.mikolaj.r2025.leetcode.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;

		for(int start = 0; start < s.length(); start++) {
			for(int end = start + 1; end <= s.length(); end++) {
				int currentLength = end - start;
				if(currentLength > maxLength && isValid(s, start, end)) {
					maxLength = currentLength;
				}
			}
		}
		return maxLength;
	}

	private boolean isValid(String s, int start, int end) {
		Set<Character> chars = new HashSet<>();
		for(int i = start; i < end; i++) {
			if (!chars.add(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
