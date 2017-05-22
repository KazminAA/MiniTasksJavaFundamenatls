package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(Kata.expandedForm(90780));
        System.out.println(new CoordinatesInspector().coordinates(90.0, 1.0));
        System.out.println(Fracts.convertFrac(new long[][]{{1, 2}, {1, 3}, {1, 4}}));
        System.out.println(ApproxInter.interp(x -> Math.sin(x), 0, 21.0, 10));
        System.out.println(Opstrings.selfieDiag2Counterclock("abcd\nefgh\nijkl\nmnop"));
    }
}
