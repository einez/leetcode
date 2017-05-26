package array;

/**
 * https://leetcode.com/problems/max-consecutive-ones/#/description
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, max = 0, temp;
        while (i < nums.length) {
            temp = 0;
            while (i < nums.length && nums[i] != 1)
                i++;
            while (i < nums.length && nums[i++] == 1)
                temp++;
            max = Math.max(max, temp);
        }
        return max;
    }
}
