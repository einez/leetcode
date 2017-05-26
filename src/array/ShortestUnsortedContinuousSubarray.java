package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/#/description
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 */

/**
 * First, create a copy of the array;
 * Second, sort the copy;
 * Third, skip the equivalent heads and tails, then we get the middle differences 'start' and 'end';
 * Last, return the difference of 'end' and 'start'.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int diff = new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums);
        System.out.println(diff);
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = 0, end = nums.length - 1;
        while (start < nums.length && nums[start] == copy[start])
            start++;
        while (end >= start && nums[end] == copy[end])
            end--;
        return end - start + 1;
    }
}
