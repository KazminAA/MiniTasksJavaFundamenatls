/*In this series of Kata, we will be implementing a software version of the Enigma Machine.

        The Enigma Machine was a message enciphering/deciphering machine used during the Second World War for disguising the content of military communications. Alan Turing - the father of computing - formulated and developed concepts that are the basis of all computers in use today, he did this in response to the vital need to break those military communications. Turing and his colleagues at Bletchley Park are generally recognised as being responsible for shortening WWII by two years and saving an estimated 22 Million lives.

        The Enigma Machine consisted of a number of parts: Keyboard for input, rotors and plugboard for enciphering, and lampboard for output.

        We will simulate input and output with strings, and build the rotors, plugboard and mechanism that used them in software. As we progress the code will become more complex, so you are advised to attempt them in order.

        Step 1: The plugboard

        In this Kata, you must implement the plugboard.

        Physical Description

        The plugboard crosswired the 26 letters of the latin alphabet togther, so that an input into one letter could generate output as another letter. If a wire was not present, then the input letter was unchanged. Each plugboard came with a maximum of 10 wires, so at least six letters were not cross-wired.

        For example:

        If a wire connects A to B, then an A input will generate a B output and a B input will generate an A output.
        If no wire connects to C, then only a C input will generate a C output.
        Note

        In the actual usage of the original Enigma Machine, punctuation was encoded as words transmitted in the stream, in our code, anything that is not in the range A-Z will be returned unchanged.

        Kata

        The Plugboard class you will implement, will:

        Take a list of wire pairs at construction in the form of a string, with a default behaviour of no wires configured. E.g. "ABCD" would wire A <-> B and C <-> D.
        Validate that the wire pairings are legitimate. Raise an exception if not.
        Implement the process method to translate a single character input into an output.
        Haskell remarks

        Since Haskell doesn't have classes, plugboard is a function that either returns a Char -> Char function for processing, or an error message.

        Examples

        Plugboard plugboard = new Plugboard("ABCDEFGHIJKLMNOPQRST");
        System.out.println(plugboard.process("A"));
        System.out.println(plugboard.process("B"));
        System.out.println(plugboard.process("X"));
        System.out.println(plugboard.process("."));
        Expected output:

        B
        A
        X
        .*/
package com.company;

import java.util.HashMap;
import java.util.Map;

public class Plugboard {
    private Map<Character, Character> wiresPairs;

    public Plugboard(String wires) throws InvalidPlugboardWiresException {
        if (!wires.matches("(?:([A-Z])(?![A-Z]*\\1)){0,20}") ||
                wires.length() % 2 != 0) {
            throw new InvalidPlugboardWiresException();
        }
        HashMap<Character, Character> pairs = new HashMap<>();
        wires = wires.toUpperCase();
        for (int i = 0; i < wires.length(); i += 2) {
            pairs.put(wires.charAt(i), wires.charAt(i + 1));
            pairs.put(wires.charAt(i + 1), wires.charAt(i));
        }
        this.wiresPairs = pairs;
    }

    public String process(String wire) {
        wire = wire.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (char c : wire.toCharArray()) {
            if (wiresPairs.containsKey(c)) {
                sb.append(wiresPairs.get(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public class InvalidPlugboardWiresException extends Exception {
    }
}
