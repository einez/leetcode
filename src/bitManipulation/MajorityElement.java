package bitManipulation;

/**
 * https://leetcode.com/problems/majority-element/#/description
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0 || ret == nums[i]) {
                count++;
                ret = nums[i];
            } else {
                count--;
            }
        }
        return ret;
    }
}
