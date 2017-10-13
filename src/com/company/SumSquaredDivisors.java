package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        List<String> tempRes = new LinkedList<>();
        for (long i = m; i <= n; i++) {
            long sumDiv = tempSumSquared(i);
            if (Math.sqrt(sumDiv) % 1 == 0) {
                tempRes.add(String.format("[%d, %d]", i, sumDiv));
            }
        }
        return "[" + tempRes.stream().collect(Collectors.joining(", ")) + "]";
    }

    private static long tempSumSquared(long x) {
        if (x == 1) return 1;
        ArrayList<Long> divisors = new ArrayList<>();
        divisors.add((long) 1);
        long maxdiv = x / (long) 2;
        for (long i = 2; i <= maxdiv; i++) {
            if (x % i == 0) divisors.add(i);
        }
        divisors.add(x);
        return divisors.stream().mapToLong(i -> i * i).sum();
    }

}
