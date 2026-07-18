package pl.mikolaj.r2025.leetcode.twosum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	Solution solution1 = new Solution();
	Solution2 solution2 = new Solution2();
	Solution3 solution3 = new Solution3();

	@Test
	void twoSumSolution1() {
		int[] nums = {2,7,11,15};
		int target = 9;

		int[] result = solution1.twoSum(nums, target);

		int[] expected = {0,1};
		assertArrayEquals(expected, result);
	}

	@Test
	void twoSumSolution2() {
		int[] nums = {3,2,4};
		int target = 6;

		int[] result = solution2.twoSum(nums, target);

		int[] expected = {1,2};
		assertArrayEquals(expected, result);
	}

	@Test
	void twoSumSolution3() {
		int[] nums = {3,2,4};
		int target = 6;

		int[] result = solution3.twoSum(nums, target);

		int[] expected = {1,2};
		assertArrayEquals(expected, result);
	}
}