package com.company;

import java.util.*;

public class SumOfK {
    private static List<Integer> sumOfK;

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        sumOfK = new ArrayList<>(ls.size() * k);
        combinations (ls, k, 0, new int[k]);
        Optional<Integer> max = sumOfK.stream().filter(p -> p <= t).max(Integer::compareTo);
        if (max.isPresent()) {return max.get();}
        return null;
    }

    private static void combinations(List<Integer> ls, int len, int beginpos, int[] comb) {
        if (len == 0) {
            sumOfK.add(Arrays.stream(comb).sum());
            return;
        }
        for (int i = beginpos; i <= ls.size() - len; i++) {
            comb[comb.length - len] = ls.get(i);
            combinations(ls, len-1, i + 1, comb);
        }
    }
}
