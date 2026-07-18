package pl.mikolaj.r2025.leetcode.palindromenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	Solution solution1 = new Solution();
	Solution2 solution2 = new Solution2();

	@Test
	void isPalindrome1() {
		int x = 121;
		assertTrue(solution1.isPalindrome(x));

		x = -121;
		assertFalse(solution1.isPalindrome(x));

		x = 10;
		assertFalse(solution1.isPalindrome(x));

		x = 1221;
		assertTrue(solution1.isPalindrome(x));

		x = 123421;
		assertFalse(solution1.isPalindrome(x));
	}

	@Test
	void isPalindrome2() {
		int x = 121;
		assertTrue(solution2.isPalindrome(x));

		x = -121;
		assertFalse(solution2.isPalindrome(x));

		x = 10;
		assertFalse(solution2.isPalindrome(x));

		x = 1221;
		assertTrue(solution2.isPalindrome(x));

		x = 123421;
		assertFalse(solution2.isPalindrome(x));
	}
}