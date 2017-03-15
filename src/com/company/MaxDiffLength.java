package com.company;

import java.util.Arrays;

public class MaxDiffLength {
    public static int mxdiflg(String[] a1, String[] a2) {
      if ((a1 == null) || (a2 == null) || (a1.length == 0) || (a2.length == 0)) {
      return -1;
      }
      int max = 0;
        for (int i = 0; i < a1.length; i++) {
            int dif = 0, len1;
            len1 = (a1[i] == null) ? 0 : a1[i].length();
            for (int j = 0; j < a2.length; j++) {
                int len2 = (a2[j] == null) ? 0 : a2[j].length();
                dif = Math.max(dif, Math.abs((len2 - len1)));
            }
            max = Math.max(max, dif);
        }
        return max;
    }

    public static int[] countPositivesSumNegatives(int[] input)
    {
        int[] result;
        if ((input == null) || (input.length == 0)) {
            result = new int[0];
        } else {
            result = new int[2];
            result[0] = (int) Arrays.stream(input).filter((p) -> p > 0).count();
            result[1] = Arrays.stream(input).filter((p) -> p < 0).sum();
        }
        return result; //return an array with count of positives and sum of negatives
    }
}
