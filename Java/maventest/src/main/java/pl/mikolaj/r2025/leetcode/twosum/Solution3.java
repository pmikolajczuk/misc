package pl.mikolaj.r2025.leetcode.twosum;

import java.util.HashMap;

public class Solution3 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int y = target - nums[i];
			Integer j = cache.get(y);
			if	(j == null) {
				cache.put(nums[i], i);
			} else {
				//found solution
				return new int[]{j,i};
			}
		}
		return null;
	}
}
