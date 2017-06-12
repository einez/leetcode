package bitManipulation;

import java.util.HashMap;
import java.util.LinkedList;
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
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (hashMap.containsKey(sub)) {
                hashMap.put(sub, hashMap.get(sub) + 1);
            } else {
                hashMap.put(sub, 1);
            }
        }
        List<String> list = new LinkedList<>();
        for (String s1 : hashMap.keySet()) {
            if (hashMap.get(s1) > 1)
                list.add(s1);
        }
        return list;
    }
}