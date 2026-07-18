package pl.mikolaj.r2025.leetcode.twosum;

import java.util.HashMap;

public class Solution2 {
	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			cache.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int y = target - nums[i];
			Integer j = cache.get(y);

			if (j != null && j != i) {
				return new int[]{i,j};
			}
		}

		return null;
	}
}
