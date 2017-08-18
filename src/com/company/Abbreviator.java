package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Abbreviator {
    /*The word i18n is a common abbreviation of internationalization the developer community
     use instead of typing the whole word and trying to spell it correctly.
     Similarly, a11y is an abbreviation of accessibility.

    Write a function that takes a string and turns any and all "words" (see below) within that string
     of length 4 or greater into an abbreviation following the same rules.

            Notes:

    A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen
     (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
    The abbreviated version of the word should have the first letter, then the number of removed characters,
    then the last letter (eg. "elephant ride" => "e6t r2e").*/
    public static String abbreviate(String string) {
        return Arrays.stream(string.split(" ")).map(s -> {
            int len = Character.isAlphabetic(s.charAt(s.length() - 1)) ? s.length() : s.length() - 1;
            if (len <= 3) return s;
            StringBuilder sb = new StringBuilder();
            int count = 0;
            sb.append(s.charAt(0));
            for (int i = 0; i < len; i++) {
                if (!Character.isAlphabetic(s.charAt(i))) {
                    if (count > 3) {
                        sb.append(count - 2);
                    } else if (count == 3) {
                        sb.append(s.charAt(i - 2));
                    }
                    if (count > 1) sb.append(s.charAt(i - 1));
                    sb.append(s.charAt(i)).append(s.charAt(i + 1));
                    count = -1;
                }
                count++;
            }
            if (count > 3) {
                sb.append(count - 2);
            } else if (count == 3) {
                sb.append(s.charAt(len - 2));
            }
            if (count > 1) sb.append(s.charAt(len - 1));
            if (len != s.length()) sb.append(s.charAt(len));
            return sb.toString();
        }).collect(Collectors.joining(" "));
    }

}
