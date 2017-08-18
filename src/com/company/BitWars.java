package com.company;

public class BitWars {
    /*Variation of this nice kata, the war has expanded and become dirtier and meaner;
    both even and odd numbers will fight with their pointy 1s. And negative integers are coming into play as well,
    with, ça va sans dire, a negative contribution (think of them as spies or saboteurs).

    Again, three possible outcomes: odds win, evens win and tie.

            Examples:

    bitsWar(new int[]{1,5,12}).equals("odds win") == true   // 1+101 vs 1100, 3 vs 2
    bitsWar(new int[]{7,-3,20}).equals("evens win") == true // 111-11 vs 10100, 3-2 vs 2
    bitsWar(new int[]{7,-3,-2,6}).equals("tie") == true     // 111-11 vs -1+110, 3-2 vs -1+2*/
    public static String bitsWar(int[] numbers) {
        int oddsPower = 0, evenPower = 0, currentNum = 0, countOf1;
        String result = "tie";
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) continue;
            countOf1 = 0;
            currentNum = (numbers[i] > 0) ? numbers[i] : numbers[i] * -1;
            while (currentNum != 0) {
                countOf1++;
                currentNum = currentNum & (currentNum - 1);
            }
            if (numbers[i] < 0) countOf1 *= -1;
            if (numbers[i] % 2 == 0) {
                evenPower += countOf1;
            } else {
                oddsPower += countOf1;
            }
        }
        if (oddsPower > evenPower) {
            result = "odds win";
        } else if (oddsPower < evenPower) {
            result = "evens win";
        }
        return result;
    }
    /*fine solution*/
    /*public static String bitsWar(int[] numbers) {
        int n = 0;
        for (final int i : numbers) {
            if (i == 0) continue;
            n += Integer.bitCount(Math.abs(i)) * (i > 0 ? 1 : -1) * (i % 2 == 0 ? 1 : -1);
        }
        return n == 0 ? "tie" : n > 0 ? "evens win" : "odds win";
    }*/
}
