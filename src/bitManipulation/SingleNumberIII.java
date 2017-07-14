package bitManipulation;

/**
 * https://leetcode.com/problems/single-number-iii/#/description
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        for (int value = 0; value <= 32; value++) {
            System.out.println(value + " : " + (value & (-value)));
        }
    }

    //    public int[] singleNumber(int[] nums) {
//        HashSet<Integer> once = new HashSet<>();
//        for (int ele : nums) {
//            if (!once.add(ele)) {
//                once.remove(ele);
//            }
//        }
//        return new int[]{(int) once.toArray()[0], (int) once.toArray()[1]};
//    }
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int ele : nums) {
            diff ^= ele;
        }
        diff &= -diff;
        int[] rets = new int[2];
        for (int ele : nums) {
            if ((ele & diff) == 0) {
                rets[0] ^= ele;
            } else {
                rets[1] ^= ele;
            }
        }
        return rets;
    }
}
