package com.company;

public class Accumul {

    public static String accum(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(String.valueOf(chars[i]).toUpperCase());
            for (int j = 0; j < i; j++) {
                sb.append(String.valueOf(chars[i]).toLowerCase());
            }
            if (i < chars.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

}
