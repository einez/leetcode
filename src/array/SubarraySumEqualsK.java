package array;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.*;

/**
 * Created by einez on 2017/5/25.
 */
public class SubarraySumEqualsK {
    private static int range=(int)1e7+1;

    //A simple test case
    private static int caseNum=20000;
    private static int[] base={-1000,-500,0,500,1000};
    public static void main(String[] args) throws Exception{
        int[] nums=new int[caseNum];
        for(int i=0;i<nums.length/2;i++) {
            nums[i] = base[new Random().nextInt(3)+2];
        }
        for(int i=nums.length/2;i<nums.length;i++){
            nums[i] = base[new Random().nextInt(3)+0];
        }
        FileWriter fout=new FileWriter(new File("D:\\fout.txt"));
        fout.write(Arrays.toString(nums));
        fout.close();
        int ret=new SubarraySumEqualsK().subarraySum(nums,1000);
//        int ret=new SubarraySumEqualsK().subarraySum(new int[]{1,1,1},2);
        System.out.println(ret);
    }
//    O(n^2), Time Limit Exceeded
//    public int subarraySum(int[] nums, int k) {
//        int p1=0,p2,ret=0;
//        while(p1<nums.length){
//            int sum=0;
//            p2=p1;
//            while(p2<nums.length){
//                sum+=nums[p2];
//                sum%=range;
//                if(sum==k)
//                    ret++;
//                p2++;
//            }
//            p1++;
//        }
//        return ret;
//    }
    public int subarraySum(int[] nums, int k) {
        int sum=0,result=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sum%=range;
            if(hashMap.containsKey(sum-k)){
                result+=hashMap.get(sum-k);
            }
            hashMap.put(sum,hashMap.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
