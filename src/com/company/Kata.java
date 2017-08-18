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

    public static int[] beggars(int[] values, int n) {
        int[] result = new int[n];
        if (values.length < n) n = values.length;
        for (int hb = 0; hb < n; hb++) {
            int i = hb;
            int sum = 0;
            while (i < values.length) {
                sum += values[i];
                i += n;
            }
            result[hb] = sum;
        }
        return result;
    }
}
