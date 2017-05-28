package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
 * Sets S[K] for 0 <= K < N are defined as follows:
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 * Sets S[K] are finite for each K and should NOT contain duplicates.
 * Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.
 */
public class ArrayNesting {
    public static void main(String[] args){
        int[] nums=new int[]{5,4,0,3,1,6,2};
        int ret=new ArrayNesting().arrayNesting(nums);
        System.out.println(ret);
    }
    public int arrayNesting(int[] nums) {
        boolean[] added=new boolean[nums.length];
        for(boolean mark:added){
            mark=false;
        }
        ArrayList<Set<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!added[i]){
                int p=i;
                Set<Integer> set=new HashSet<>();
                while(!set.contains(nums[p])){
                    set.add(nums[p]);
                    added[p]=true;
                    p=nums[p];
                }
                list.add(set);
            }
        }
        int maxSize=Integer.MIN_VALUE;
        for(Set<Integer> set:list){
            if(set.size()>maxSize){
                maxSize=set.size();
            }
        }
        return maxSize;
    }
}
