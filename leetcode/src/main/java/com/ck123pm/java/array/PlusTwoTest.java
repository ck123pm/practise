package com.ck123pm.java.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @description:
 * @author: jianshli
 * @create: 2020-08-07 15:45
 **/
class PlusTwoTest {

    @Test
    void twoSum() {
        PlusTwo plusTwo = new PlusTwo();
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        System.out.println(Arrays.toString(plusTwo.twoSum2(nums, target)));
    }

    @Test
    void twoSum2() {
        PlusTwo plusTwo = new PlusTwo();
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(plusTwo.twoSum2(nums, target)));
    }

}