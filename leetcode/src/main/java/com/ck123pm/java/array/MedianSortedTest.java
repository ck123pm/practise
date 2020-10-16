package com.ck123pm.java.array;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: jianshli
 * @create: 2020-08-17 14:08
 **/
class MedianSortedTest {

    @Test
    void findMedianSortedArrays() {
        MedianSorted medianSorted = new MedianSorted();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println(medianSorted.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    void findMedianSortedArrays2() {
        MedianSorted medianSorted = new MedianSorted();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(medianSorted.findMedianSortedArrays(nums1, nums2));
    }
}