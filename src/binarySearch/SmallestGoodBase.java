package binarySearch;


/**
 * https://leetcode.com/problems/smallest-good-base/#/description
 * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
 * Now given a string representing n, you should return the smallest good base of n in string format.
 * 1. The range of n is [3, 10^18].
 * 2. The string representing n is always valid and will not have leading zeros.
 */
public class SmallestGoodBase {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        String ret = new SmallestGoodBase().smallestGoodBase("2251799813685247");
        System.out.println(ret);
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //O(n^0.5*log(n)) TLE
//    public String smallestGoodBase(String n) {
//        long dn = Long.valueOf(n);
//        for (int i = 2; i * i < dn; i++) {
//            long seq = 1;
//            long ins = i;
//            while (seq < dn) {
//                seq += ins;
//                ins *= i;
//            }
//            if (seq == dn) {
//                return String.valueOf(i);
//            }
//        }
//        return String.valueOf(dn - 1);
//    }

    public String smallestGoodBase(String n) {
        long dn = Long.valueOf(n);
        int i;
        for (i = 1; dn >> i >= 1; i++)
            ;
        while (i > 2) {
            long ret = iLenGoodBase(dn, i);
            if (ret != 0) {
                return String.valueOf(ret);
            }
            i--;
        }
        return String.valueOf(dn - 1);
    }

    public long iLenGoodBase(long dn, int iLen) {
        if (iLen == 1) {
            return dn == 1 ? 1 : 0;
        } else if (iLen < 1) {
            return 0;
        }
        long ceil = Math.round(0.5 + Math.pow(dn, 1.0 / (iLen - 1)));
        long floor = Math.round(-0.5 + Math.pow(dn / 2.0, 1.0 / (iLen - 1)));
        while (ceil >= floor) {
            long candidate = floor + (ceil - floor) / 2;
            long sum = 0;
            for (int i = 0; i < iLen; i++) {
                sum *= candidate;
                sum += 1;
            }
            if (sum == dn) {
                return candidate;
            } else if (sum < dn) {
                floor = candidate + 1;
            } else {
                ceil = candidate - 1;
            }
        }
        return 0;
    }
}
