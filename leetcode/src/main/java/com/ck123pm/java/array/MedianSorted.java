package com.ck123pm.java.array;

import java.util.PriorityQueue;

/**
 * @description: 寻找两个正序数组的中位数
 * @author: jianshli
 * @create: 2020-08-17 10:45
 **/
public class MedianSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            queue.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            queue.add(nums2[i]);
        }
        if (queue.size() % 2 == 0) {
            Integer mid = queue.size() / 2;
            for (int i = 0; i < mid - 1; i++) {
                queue.poll();
            }
            Integer first = queue.poll();
            Integer second = queue.poll();

            return (double) (first + second) / 2.0;
        } else {
            Integer mid = queue.size() / 2;
            for (int i = 0; i < mid; i++) {
                queue.poll();
            }
            return (double) queue.poll();
        }

    }
}
