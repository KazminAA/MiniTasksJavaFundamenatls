package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneDir {

    public static String phone(String strng, String num) {
        List<String> coinciding = new ArrayList<>();
        String[] splited = strng.split("\n");
        Pattern p = Pattern.compile("\\+(\\d+-\\d{3}-\\d{3}-\\d{4})");
        Matcher m;
        NbNumber result = new NbNumber(num);
        for (String s : splited) {
            m = p.matcher(s);
            while (m.find()) {
                if (m.group(1).equals(num)) {
                    coinciding.add(s);
                }
            }
        }
        if (coinciding.size() == 0) return "Error => Not found: " + num;
        if (coinciding.size() > 1) return "Error => Too many people: " + num;
        p = Pattern.compile("(<)([\\S\\s]*)(>)");
        m = p.matcher(coinciding.get(0));
        while (m.find()) {
            result.setName(m.group(2));
        }
        p = Pattern.compile("(.*)(?:\\+\\d+-\\d{3}-\\d{3}-\\d{4})(.*)");
        m = p.matcher(coinciding.get(0));
        while (m.find()) {
            coinciding.set(0, m.group(1) + m.group(2));
        }
        p = Pattern.compile("(.*)(?:<[\\s\\S]*>)(.*)");
        m = p.matcher(coinciding.get(0));
        while (m.find()) {
            coinciding.set(0, m.group(1) + m.group(2));
        }
        coinciding.set(0,
                Arrays.stream(coinciding.get(0).replaceAll("[^\\w\\s-.]", "").split(" "))
                        .filter(s -> !s.equals(""))
                        .map(s -> s = s.trim().replaceAll("_", " "))
                        .collect(Collectors.joining(" ")));
        result.setAddress(coinciding.get(0));
        return result.toString();
    }

    public static class NbNumber {
        private String phone;
        private String name;
        private String address;

        public NbNumber(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Phone => " + phone +
                    ", Name => " + name +
                    ", Address => " + address;
        }
    }
}
