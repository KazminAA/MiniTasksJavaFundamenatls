package com.company;

public class Xbonacci {

    public static double[] tribonacci(double[] s, int n) {
        double[] result = new double[n];
        if (n > s.length) {
            System.arraycopy(s, 0, result, 0, s.length);
            for (int i = 3; i < result.length; i++) {
                result[i] = result[i - 1] + result[i - 2] + result[i - 3];
            }
        } else {
            System.arraycopy(s, 0, result, 0, n);
        }
        return result;
    }
}
