package pl.mikolaj.r2025.leetcode.palindromenumber;

class Solution {
	public boolean isPalindrome(int x) {
		String xStr = String.valueOf(x);

		StringBuilder xStrReverse = new StringBuilder();
		for (int i = xStr.length() - 1; i >= 0; i--) {
			xStrReverse.append(xStr.charAt(i));
		}

		return xStr.contentEquals(xStrReverse);
	}
}