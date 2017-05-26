package array;

import java.util.HashMap;

/**
 * Created by einez on 2017/5/26.
 */
public class K_diffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(Math.max(nums[i],nums[j])-Math.min(nums[i],nums[j])==k){
                    if(!hashMap.containsKey(Math.min(nums[i],nums[j]))){
                        count++;
                        hashMap.put(Math.min(nums[i],nums[j]),Math.max(nums[i],nums[j]));
                    }
                }
            }
        }
        return count;
    }
}
