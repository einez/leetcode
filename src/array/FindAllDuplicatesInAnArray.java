package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/#/description
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = new FindAllDuplicatesInAnArray().findDuplicates(nums);
        for (Integer ele : list) {
            System.out.println(ele);
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % (nums.length + 1) - 1] += nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] / (nums.length + 1) == 2) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
