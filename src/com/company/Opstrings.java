package com.company;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Opstrings {
    public static String vertMirror (String strng) {
        String[] strArr = strng.split("\n");
        StringBuilder sb = new StringBuilder();
        StringBuilder tmpsb;
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            tmpsb = new StringBuilder(strArr[i]);
            tmpsb.reverse();
            if (i != (len - 1)) {
                tmpsb.append("\n");
            }
            sb.append(tmpsb.toString());
        }
        return sb.toString();
    }
    public static String horMirror (String strng) {
        String[] strArr = strng.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            sb.append(strArr[i]);
            if (i != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String rot90Counter(String strng) {
        final int lineLength = strng.split("\n")[0].length();
        return Stream.iterate(lineLength - 1, i -> i - 1).limit(lineLength)
                .map(i ->
                        Arrays.stream(strng.split("\n")).map(s -> Character.toString(s.charAt(i))).collect(Collectors.joining(""))
                ).collect(Collectors.joining("\n"));
    }

    public static String diag2Sym(String strng) {
        return Arrays.stream(rot90Counter(strng).split("\n"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining("\n"));
    }

    public static String selfieDiag2Counterclock(String strng) {
        String[] strArr = strng.split("\n");
        String[] diag = diag2Sym(strng).split("\n");
        String[] rot90 = rot90Counter(strng).split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            sb.append("|");
            sb.append(diag[i]);
            sb.append("|");
            sb.append(rot90[i]);
            if (i != strArr.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
}
