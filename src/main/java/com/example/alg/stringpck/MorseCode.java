package com.example.alg.stringpck;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {

    /**
     * 804. Unique Morse Code Words
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
     *
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
     *
     * Return the number of different transformations among all words we have.
     *
     * Complexity Analysis
     *
     * Time Complexity: O(S)O(S), where SS is the sum of the lengths of words in words.
     * We iterate through each character of each word in words.
     *
     * Space Complexity: O(S)O(S).
     */
    public int uniqueMorseRepresentations(String[] words) {

        String[] morseDictionary = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

    Set<String> morseRepresentations = new HashSet<>();

        for (String word : words) {
            StringBuilder morseResult = new StringBuilder();


            for(char character : word.toCharArray()){
                morseResult.append(morseDictionary[character-'a']);
            }

            morseRepresentations.add(morseResult.toString());

        }

        return morseRepresentations.size();
    }

}
