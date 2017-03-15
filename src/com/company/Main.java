package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        System.out.println(MaxDiffLength.mxdiflg(s1, s2));
        // write your code here
        System.out.println(Arrays.toString(MaxDiffLength.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14})));
        String s3 = "abcd\nefgh\nijkl\nmnop";
        System.out.println(Opstrings.vertMirror(s3));
        System.out.println(Opstrings.horMirror(s3));
        System.out.println(SumOfK.chooseBestSum(163, 3, new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58))));
    }
}
