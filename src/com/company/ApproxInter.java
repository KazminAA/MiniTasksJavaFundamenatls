package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class ApproxInter {
    public static List<Double> interp(DoubleUnaryOperator f, double l, double u, int n) {
        double d = (u - l) / n;
        List<Double> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(Math.floor(f.applyAsDouble(l) * 100.0) / 100.0);
            l += d;
        }
        return result;
    }
}
