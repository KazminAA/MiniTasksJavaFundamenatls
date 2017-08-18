package com.company;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLComplementaryColor {
    public static String getReversedColor(String hexColor) throws IllegalArgumentException {
        if (hexColor == null || hexColor.equals("")) return "#FFFFFF";
        Pattern p = Pattern.compile("([^0-9a-fA-F]+)");
        Matcher m = p.matcher(hexColor);
        if (m.find() || hexColor.length() > 6) throw new IllegalArgumentException();
        Long l = 16777215 - Long.parseUnsignedLong(hexColor, 16);
        return "#" + Long.toHexString(l).toUpperCase();
    }
}
