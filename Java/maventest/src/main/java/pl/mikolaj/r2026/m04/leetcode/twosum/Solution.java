package pl.mikolaj.r2026.m04.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> cache = new HashMap<>(nums.length);
		for(int i = 0; i < nums.length; i++) {
			cache.put(nums[i],i);
		}

		for (int i = 0; i < nums.length; i++) {
			int y = target - nums[i];

			Integer j = cache.get(y);
			if(j != null && j != i) {
				return new int[]{i,j};
			}
		}
		return new int[]{-1,-1};
	}
}
