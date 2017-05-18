package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Accumul.accum("RqaEzty"));
        System.out.println(Order.order("is2 Thi1s T4est 3a"));
        System.out.println(Dubstep.SongDecoder("RWUBWUBWUBLWUB"));
        System.out.println(Arrays.toString(Xbonacci.tribonacci(new double[]{1, 1, 1}, 10)));
        System.out.println(Kata.expandedForm(90780));
        System.out.println(new CoordinatesInspector().coordinates(90.0, 1.0));
        System.out.println(Fracts.convertFrac(new long[][]{{1, 2}, {1, 3}, {1, 4}}));
    }
}
