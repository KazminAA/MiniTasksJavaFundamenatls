package com.company;

public class VolTank {
    public static int tankVol(int h, int d, int vt) {
        double r = 0.5 * d;
        double t = 2 * Math.acos(1 - h / r);
        double a = 0.5 * r * r * (t - Math.sin(t));
        double k = vt / (r * r * Math.PI);
        return (int) (a * k);
    }
}
