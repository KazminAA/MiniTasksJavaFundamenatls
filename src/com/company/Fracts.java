package com.company;

public class Fracts {
    public static long gcdi(long x, long y) {
        if (y == 0) {
            return x;
        } else {
            return gcdi(y, x % y);
        }
    }

    public static long lcmu(long a, long b) {
        return a * b / gcdi(a, b);
    }

    public static String convertFrac(long[][] lst) {
        long lcmu = 1;
        StringBuilder sb = new StringBuilder();
        for (long[] pair : lst) {
            lcmu = lcmu(lcmu, pair[1]);
        }
        for (long[] pair : lst) {
            sb.append("(");
            sb.append((int) (((double) pair[0] / pair[1]) * lcmu));
            sb.append(",");
            sb.append(lcmu);
            sb.append(")");
        }
        return sb.toString();
    }
}
