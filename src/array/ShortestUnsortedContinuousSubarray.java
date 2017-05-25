package array;

import java.util.Arrays;

/**
 * First, create a copy of the array;
 * Second, sort the copy;
 * Third, skip the equivalent heads and tails, then we get the middle differences 'start' and 'end';
 * Last, return the difference of 'end' and 'start'.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args){
        int[] nums=new int[]{2,6,4,8,10,9,15};
        int diff=new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums);
        System.out.println(diff);
    }
    public int findUnsortedSubarray(int[] nums) {
        int[] copy=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copy);
        int start=0,end=nums.length-1;
        while(start<nums.length&&nums[start]==copy[start])
            start++;
        while(end>=start&&nums[end]==copy[end])
            end--;
        return end-start+1;
    }
}
