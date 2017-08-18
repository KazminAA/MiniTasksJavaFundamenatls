package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqProd2Sum {
    public static List<long[]> prod2Sum(long a, long b, long c, long d) {
        List<long[]> result = new ArrayList<>();
        long[] first = new long[2];
        long[] second = new long[2];
        first[0] = Math.abs(a * c + b * d);
        first[1] = Math.abs(a * d - b * c);
        Arrays.sort(first);
        result.add(first);
        second[0] = Math.abs(a * c - b * d);
        second[1] = Math.abs(a * d + b * c);
        Arrays.sort(second);
        if (second[0] != first[0] && second[1] != first[1])
            result.add(second);
        return result;
    }
}
