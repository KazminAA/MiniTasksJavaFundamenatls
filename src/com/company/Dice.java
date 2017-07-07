package com.company;

public class Dice {

    public static int[] rollDices(int count) {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = (int) (Math.random() * 6) + 1;
        }
        return result;
    }
}
