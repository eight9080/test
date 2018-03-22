package com.example.alg.stringpck;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

 Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

 It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

 The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

 Example 1:
 Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 Output: "steps"
 Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
 Note that the answer is not "step", because the letter "s" must occur in the word twice.
 Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
 Example 2:
 Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 Output: "pest"
 Explanation: There are 3 smallest length words that contains the letters "s".
 We return the one that occurred first.
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        final Map<Character, Long> characters = licensePlate.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final int minCharacters = characters.size();
        long minLength = characters.values().stream().reduce(0L, (a,b) -> a+b);

        String minWord = null;

        for (String word: words) {

            if(minLength>word.length()){
                continue;
            }

            final Map<Character, Long> charactersWord = word.chars()
                    .mapToObj(c -> (char) c)
                    .filter(Character::isLetter)
                    .map(Character::toLowerCase)
                    .filter(characters::containsKey)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            if(charactersWord.size()<minCharacters){
                continue;
            }

            boolean valid = true;
            for (Map.Entry<Character, Long> entry: charactersWord.entrySet()){
                if(characters.get(entry.getKey())>entry.getValue()){
                    valid=false;
                    break;
                }
            }

            if(!valid){
                continue;
            }

            if(minWord==null || minWord.length()>word.length()){
                minWord=word;
            }

        }

        return minWord;
    }
}
