package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Kata.expandedForm(90780));
        System.out.println(ApproxInter.interp(x -> Math.sin(x), 0, 21.0, 10));
        System.out.println(Opstrings.selfieDiag2Counterclock("abcd\nefgh\nijkl\nmnop"));
        System.out.println(Arrays.toString(Kata.beggars(new int[]{1, 2, 3, 4, 5}, 6)));
        System.out.println(CodeDecode.code("I.was.going.fishing.that.morning.at.ten.o'clock"));
        System.out.println(CodeDecode.decode("c.nhsoI\nltiahi.\noentinw\ncng.nga\nk..mg.s\n\u000Boao.f.\n\u000B'trtig\n"));
    }
}
