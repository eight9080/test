package com.example.alg.stringpck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GoatLatin {
    /**
     * 824. Goat Latin
     * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
     *
     * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
     *
     * The rules of Goat Latin are as follows:
     *
     * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
     * For example, the word 'apple' becomes 'applema'.
     *
     * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
     * For example, the word "goat" becomes "oatgma".
     *
     * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
     * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
     */
    public String toGoatLatin(String S) {

        final String[] words = S.split("\\s+");

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E',  'I', 'O', 'U');
        String suffix = "ma";
        String lastStayVowel = "a";
        StringBuilder lastSay = new StringBuilder();
        StringBuilder newPhrase = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            final char firstLetter = words[i].charAt(0);
            if(vowels.contains(firstLetter)){
                words[i] = words[i]+suffix+lastSay.append(lastStayVowel);
            }else {
                String newWord = words[i];
                if(words[i].length()>1){
                     newWord = words[i].substring(1) + firstLetter;
                }
                words[i] = newWord+suffix+lastSay.append(lastStayVowel);
            }
            newPhrase.append(words[i])
                    .append(" ");

        }

        return newPhrase.toString().trim();

    }
}
