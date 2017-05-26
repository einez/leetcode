package array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/#/description
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 */
public class K_diffPairsInAnArray {
    //    public int findPairs(int[] nums, int k) {
//        int count = 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (Math.max(nums[i], nums[j]) - Math.min(nums[i], nums[j]) == k) {
//                    if (!hashMap.containsKey(Math.min(nums[i], nums[j]))) {
//                        count++;
//                        hashMap.put(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j]));
//                    }
//                }
//            }
//        }
//        return count;
//    }
    public static void main(String[] args) {
        int ret = new K_diffPairsInAnArray().findPairs(new int[]{1, 3, 1, 5, 4}, 0);
        System.out.println(ret);
    }

    public int findPairs(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.getOrDefault(nums[i], 0) == 1)
                    count++;
                hashMap.put(nums[i], 1 + hashMap.getOrDefault(nums[i], 0));
            }
        } else if (k < 0)
            return 0;
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!hashMap.containsKey(nums[i])) {
                    hashMap.put(nums[i], nums[i]);
                    if (hashMap.containsKey(nums[i] + k))
                        count++;
                    if (hashMap.containsKey(nums[i] - k))
                        count++;
                }
            }
        }
        return count;
    }
}
