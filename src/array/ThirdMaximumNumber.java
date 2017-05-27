package array;


/**
 * https://leetcode.com/problems/third-maximum-number/#/description
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {
    public static void main(String[] args){
        int[] nums=new int[]{1};
        int ret=new ThirdMaximumNumber().thirdMax(nums);
        System.out.println(ret);
    }
    public int thirdMax(int[] nums) {
        Integer[] store=new Integer[3];
        for(int i=0;i<store.length;i++){
            for(int ele:nums){
                if((i==0||store[i-1]!=null&&ele<store[i-1])&&(store[i]==null||ele>store[i])){
                    store[i]=ele;
                }
            }
        }
        return store[2]!=null?store[2]:store[0];
    }
}
