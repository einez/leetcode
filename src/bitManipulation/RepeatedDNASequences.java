package bitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/#/description
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        List<String> list = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> once = new HashSet<>();
        HashSet<String> twice = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            if (!once.add(s.substring(i, i + 10))) {
                twice.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(twice);
    }

//    public List<String> findRepeatedDnaSequences(String s) {
//        HashSet<Integer> once = new HashSet<>();
//        HashSet<Integer> twice = new HashSet<>();
//        List<String> ret = new LinkedList<>();
//        int[] mapping = new int[26];
//        mapping['A' - 'A'] = 0;
//        mapping['T' - 'A'] = 1;
//        mapping['C' - 'A'] = 2;
//        mapping['G' - 'A'] = 3;
//        int bitCode = 0;
//        for (int i = 0; i < 9 && i < s.length(); i++) {
//            bitCode <<= 2;
//            bitCode |= mapping[s.charAt(i) - 'A'];
//        }
//        for (int i = 9; i < s.length(); i++) {
//            bitCode <<= 2;
//            bitCode &= 0xfffff;
//            bitCode |= mapping[s.charAt(i) - 'A'];
//            if (!once.add(bitCode) && twice.add(bitCode)) {
//                ret.add(s.substring(i - 9, i + 1));
//            }
//        }
//        return ret;
//    }
}