/*The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollars bill. A "Avengers" ticket costs 25 dollars.

        Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

        Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the order people follow in the line?

        Return YES, if Vasya can sell a ticket to each person and give the change. Otherwise return NO.

        ###Examples:

// *** Java ***

        Line.Tickets(new int[] {25, 25, 50}) // => YES
        Line.Tickets(new int []{25, 100})
        // => NO. Vasya will not have enough money to give change to 100 dollars*/
package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Line {

    public static String Tickets(int[] peopleInLine) {
        List<Integer> changeLine = new LinkedList<>();
        for (int bill : peopleInLine) {
            if (bill == 25) {
                changeLine.add(bill);
            } else {
                if (changeLine.size() == 0) return "NO";
                else {
                    int change = bill - 25;
                    Iterator<Integer> iter = changeLine.iterator();
                    while (change != 0 && iter.hasNext()) {
                        int temp = iter.next();
                        if (change - temp < 0) continue;
                        else {
                            change -= temp;
                            iter.remove();
                        }
                    }
                    if (change != 0) return "NO";
                    else changeLine.add(bill);
                    changeLine.sort((x, y) -> y - x);
                }
            }
        }
        return "YES";
    }
}
