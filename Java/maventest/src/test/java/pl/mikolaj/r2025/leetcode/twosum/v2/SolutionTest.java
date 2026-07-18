package pl.mikolaj.r2025.leetcode.twosum.v2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	Solution solution1 = new Solution();

	@Test
	void twoSum() {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] result = solution1.twoSum(nums, target);
		assertArrayEquals(new int[]{0,1}, result);

		nums = new int[]{3,2,4};
		target = 6;
		result = solution1.twoSum(nums, target);
		assertArrayEquals(new int[]{1,2}, result);

		nums = new int[]{3,3};
		target = 6;
		result = solution1.twoSum(nums, target);
		assertArrayEquals(new int[]{0,1}, result);
	}
}