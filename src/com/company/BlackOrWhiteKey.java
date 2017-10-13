package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BlackOrWhiteKey {
    private static Set<Integer> pianoBlackKeys = new HashSet<>(
            Arrays.asList(new Integer[]{2, 5, 7, 10, 12, 14, 17, 19, 22, 24, 26,
                    29, 31, 34, 36, 38, 41, 43, 46, 48, 50, 53, 55, 58, 60, 62, 65, 67,
                    70, 72, 74, 77, 79, 82, 84, 86}));

    public static String blackOrWhiteKey(int keyPressCount) {
        if (keyPressCount > 88) keyPressCount %= 88;
        if (pianoBlackKeys.contains(keyPressCount)) return "black";
        return "white";
    }
}
