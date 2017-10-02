package com.example.alg.stringpck;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    /**
     * Given a pattern and a string str, find if str follows the same pattern.

     Here follow means a full match, such that there is a bijection between
     a letter in pattern and a non-empty word in str.

     Examples:
     pattern = "abba", str = "dog cat cat dog" should return true.
     pattern = "abba", str = "dog cat cat fish" should return false.
     pattern = "aaaa", str = "dog cat cat dog" should return false.
     pattern = "abba", str = "dog dog dog dog" should return false.
     Notes:
     You may assume pattern contains only lowercase letters, and str contains lowercase
     letters separated by a single space.
     */

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;
        Map<Character, String> characterByWord = new HashMap<>();
        final char[] characters = pattern.toCharArray();
        for(int i = 0; i< characters.length; i++){
            final char character = characters[i];
            final String word = words[i];
            if(!characterByWord.containsKey(character) && !characterByWord.containsValue(word)){
                characterByWord.put(character, word);
            }else {
                if(characterByWord.containsKey(character)) {
                    final String mappedWord = characterByWord.get(character);
                    if (!mappedWord.equals(word)) {
                        return false;
                    }
                }else if(characterByWord.containsValue(word)){
                    return false;
                }
            }
        }
        return true;
    }
}
