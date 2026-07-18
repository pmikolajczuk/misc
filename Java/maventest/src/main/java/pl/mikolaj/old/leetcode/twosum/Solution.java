package pl.mikolaj.old.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer idx1 = map.get(target - nums[i]);
            if(idx1 != null) {
                return new int[]{idx1, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
