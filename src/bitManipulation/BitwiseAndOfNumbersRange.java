package bitManipulation;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/#/description
 */
public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
//        int result = new BitwiseAndOfNumbersRange().rangeBitwiseAnd(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
        int result = new BitwiseAndOfNumbersRange().rangeBitwiseAnd(1, 3);
        System.out.println(result);
    }

    //    public int rangeBitwiseAnd(int m, int n) {
//        int ret = 0;
//        while (m > 0 && floor(m) == floor(n)) {
//            int tmp = floor(m);
//            ret |= tmp;
//            m -= tmp;
//            n -= tmp;
//        }
//        return ret;
//    }
//
//    public int floor(int m) {
//        int ret = 1;
//        while (m > 1) {
//            m >>= 1;
//            ret <<= 1;
//        }
//        return ret;
//    }
    public int rangeBitwiseAnd(int m, int n) {
        int comn = m ^ n;
        int count = 0;
        while (comn > 0) {
            comn >>= 1;
            count++;
        }
        return m & n & ~((1 << count) - 1);
    }
}
