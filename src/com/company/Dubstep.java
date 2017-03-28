package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dubstep {

    public static String SongDecoder(String song) {
        return Arrays.stream(song.split("WUB"))
                .filter((p) -> !p.equals("") && !p.equals(" "))
                .collect(Collectors.joining(" "));
    }

    public static int FindShort(String s) {
        return Arrays.stream(s.split(" "))
                .map(p -> p.length()).min(Integer::compareTo).get();

    }

}
