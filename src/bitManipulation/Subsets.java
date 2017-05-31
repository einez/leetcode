package bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/#/description
 * Given a set of distinct integers, nums, return all possible subsets.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = new Subsets().subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public List<List<Integer>> subsets(int[] nums, int start) {
        List<List<Integer>> list = new ArrayList<>();
        if (start < nums.length) {
            List<List<Integer>> subList = subsets(nums, start + 1);
            list.addAll(subList);
            for (List<Integer> sub : subList) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.addAll(sub);
                arrayList.add(0, nums[start]);
                list.add(arrayList);
            }
        } else {
            list.add(new ArrayList<>());
        }
        return list;
    }
}
