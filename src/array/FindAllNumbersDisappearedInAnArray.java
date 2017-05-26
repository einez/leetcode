package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/#/description
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int size = 100000;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = new Random().nextInt(size) + 1;
        }
        List list = new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums);
        for (Object obj : list)
            System.out.println(obj);
    }

    //TLE
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> list=new ArrayList<>();
//        for(int i=1;i<=nums.length;i++)
//            list.add(i);
//        for(int ele:nums){
//            list.set(ele-1,0);
//        }
//        int it=0;
//        while (it<list.size()){
//            if(list.get(it)==0)
//                list.remove(it);
//            else it++;
//        }
//        return list;
//    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
            else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                list.add(i + 1);
        }
        return list;
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
