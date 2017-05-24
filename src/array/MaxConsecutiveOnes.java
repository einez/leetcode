package array;

/**
 * Created by einez on 2017/5/24.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,max=0,temp;
        while(i<nums.length) {
            temp=0;
            while (i < nums.length && nums[i] != 1)
                i++;
            while (i < nums.length && nums[i++] == 1)
                temp++;
            max = Math.max(max, temp);
        }
        return max;
    }
}
