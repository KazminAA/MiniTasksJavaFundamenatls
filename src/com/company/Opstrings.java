package com.company;

import java.util.function.UnaryOperator;

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
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
}
