package com.ck123pm.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: plus two numbers
 * @author: jianshli
 * @create: 2020-08-07 15:38
 **/
public class PlusTwo {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];
            if (map.containsKey(compare)) {
                return new int[]{i, map.get(compare)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
