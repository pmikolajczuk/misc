package pl.mikolaj.r2025.leetcode.twosum.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSumBruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{-1, -1};
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> cache = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			cache.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			Integer y = target - x;
			Integer j = cache.get(y);
			if (j != null && j != i) {
				return new int[]{i, j};
			}
		}
		return new int[]{-1, -1};
	}
}
