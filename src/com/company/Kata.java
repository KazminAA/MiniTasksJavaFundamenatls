package com.company;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Kata {
    public static String expandedForm(int num) {
        char[] numbers = new Integer(num).toString().toCharArray();
        int len = numbers.length - 1;
        ArrayList<String> tmpresult = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            double tmpnum = new Integer(String.valueOf(numbers[i])) * Math.pow(10, len);
            if (tmpnum != 0) {
                tmpresult.add(new Integer((int) tmpnum).toString());
            }
            len--;
        }
        return tmpresult.stream().collect(Collectors.joining(" + "));
    }
}
