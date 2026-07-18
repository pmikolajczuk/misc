package pl.mikolaj.r2025.leetcode.palindromenumber;

public class Solution2 {
	public boolean isPalindrome(int x) {
		String xStr = x + "";

		for(int i = 0; i < xStr.length() / 2; i++)
			if(xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)){
				return false;
			}

		return true;
	}
}
