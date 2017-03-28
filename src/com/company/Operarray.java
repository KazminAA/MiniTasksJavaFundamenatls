package com.company;

import java.util.function.BinaryOperator;

public class Operarray {
    public static long gcdi(long x, long y) {
        if (y == 0) {
            return Math.abs(x);
        } else {
            return gcdi(Math.abs(y), Math.abs(x) % Math.abs(y));
        }
    }

    public static long lcmu(long a, long b) {
        return Math.abs(a) * Math.abs(b) / gcdi(a, b);
    }

    public static long som(long a, long b) {
        return a + b;
    }

    public static long maxi(long a, long b) {
        return Math.max(a, b);
    }

    public static long mini(long a, long b) {
        return Math.min(a, b);
    }

    public static long[] operArray(BinaryOperator<Long> operator, long[] arr, long init) {
        long[] result = new long[arr.length];
        result[0] = operator.apply(init, arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result[i] = operator.apply(result[i - 1], arr[i]);
        }
        return result;
    }
}
