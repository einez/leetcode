package binarySearch;

/**
 * https://leetcode.com/problems/heaters/#/description
 */

import java.util.Arrays;

/**
 * Solution: sort the heaters' positions;
 * for each house(i), find the nearest heater r(i);
 * the max r(i) is the minimum radius.
 */
public class Heaters {

    public static void main(String[] args) {
        int ret = new Heaters().findRadius(new int[]{1, 2, 3}, new int[]{2});
        System.out.println(ret);
    }

    //    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(heaters);
//        Arrays.binarySearch(heaters,1);
//        int ret = Integer.MIN_VALUE;
//        for (int house : houses) {
//            int dist = distOfNearestHeater(house, heaters);
//            ret = Math.max(ret, dist);
//        }
//        return ret;
//    }
//
//    public int distOfNearestHeater(int housePostion, int[] heaters) {
//        int low = 0, high = heaters.length - 1;
//        if (heaters[low] >= housePostion) {
//            return heaters[low] - housePostion;
//        } else if (heaters[high] <= housePostion) {
//            return housePostion - heaters[high];
//        }
//        while (low < high - 1) {
//            int mid = low + (high - low) / 2;
//            if (heaters[mid] > housePostion) {
//                high = mid;
//            } else if (heaters[mid] < housePostion) {
//                low = mid;
//            } else {
//                return 0;
//            }
//        }
//        return Math.min(housePostion - heaters[low], heaters[high] - housePostion);
//    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ret = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            index = (index >= 0) ? index : -(index + 1);
            int dist1 = (index == heaters.length) ? Integer.MAX_VALUE : heaters[index] - house;
            int dist2 = (index == 0) ? Integer.MAX_VALUE : house - heaters[index - 1];
            int dist = Math.min(dist1, dist2);
            ret = Math.max(ret, dist);
        }
        return ret;
    }
}
