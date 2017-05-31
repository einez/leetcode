package binarySearch;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/4sum-ii/#/description
 */
public class FourSumII {

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, -1, -1};
        int[] B = new int[]{-1, -1, 1, 1};
        int[] C = new int[]{1, -1, 0, -1};
        int[] D = new int[]{1, 1, -1, 1};
        int ret = new FourSumII().fourSumCount(A, B, C, D);
        System.out.println(ret);
        System.out.println("--Following is for simple inspection--");
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                for (int c : C) {
                    for (int d : D) {
                        if (a + b + c + d == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
//Takes too long
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int[] AB = combineArray(A, B);
//        int[] CD = combineArray(C, D);
//        for (int i = 0; i < AB.length; i++) {
//            AB[i] = -AB[i];
//        }
//        int count = 0;
//        for (int ab : AB) {
//            int index = Arrays.binarySearch(CD, ab);
//            if (index >= 0) {
//                int right = index, left = index - 1;
//                while (right < CD.length && CD[right] == ab) {
//                    right++;
//                }
//                while (left >= 0 && CD[left] == ab) {
//                    left--;
//                }
//                count += right - left - 1;
//            }
//        }
//        return count;
//    }
//
//    public int[] combineArray(int[] A, int[] B) {
//        int[] AB=new int[A.length*B.length];
//        int ab=0;
//        for(int a:A){
//            for(int b:B){
//                AB[ab++]=a+b;
//            }
//        }
//        Arrays.sort(AB);
//        return AB;
//    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                hashMap.put(-a - b, hashMap.getOrDefault(-a - b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                count += hashMap.getOrDefault(c + d, 0);
            }
        }
        return count;
    }
}
