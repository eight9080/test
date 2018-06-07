package com.example.alg.stringpck;

import java.util.*;

public class Palindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters
     * and ignoring cases.

     For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
     */
    public static boolean isValidPalindrome(String s){
        if(s==null ){
            return false;
        }
        if(s.length()==0){
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

     Example 1:
     Input: "aba"
     Output: True
     Example 2:
     Input: "abca"
     Output: True
     Explanation: You could delete the character 'c'.
     Note:
     The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
     */
    public boolean isValidPalidrome2(String s){
        if(s==null ){
            return false;
        }
        if(s.length()==0){
            return true;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = -1, right = s.length();
        while (++left < --right){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalidrome(s, left-1, right) || isPalidrome(s, left, right+1);
            }
        }
        return true;
    }

    private boolean isPalidrome(String s, int left, int right){
        while (++left < --right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
        }
        return true;
    }

    /**
     * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
     * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

     Example 1:
     Given words = ["bat", "tab", "cat"]
     Return [[0, 1], [1, 0]]
     The palindromes are ["battab", "tabbat"]
     */
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        HashMap<String, Integer> mapIndex = new HashMap<>();
        for(int i=0; i<words.length; i++){
            mapIndex.put(words[i], i);
        }

        for(int i = 0; i< words.length; i++){
            String word = words[i];

            //if the word is a palindrome, get index of ""
            if(isPalindrome(word)){
                final Optional<Integer> pairWordIndex = findPairIndex("", i, mapIndex);
                if(pairWordIndex.isPresent()){
                    result.add(Arrays.asList( i, pairWordIndex.get()));
                    result.add(Arrays.asList( pairWordIndex.get(), i));
                }
            }

            final Optional<Integer> pairWordIndex = findPairIndex(word, i, mapIndex);
            if(pairWordIndex.isPresent()){
                result.add(Arrays.asList( i, pairWordIndex.get()));
            }

            for(int k=1; k<word.length(); k++) {
                String left = word.substring(0, k);
                String right = word.substring(k);

                if(isPalindrome(left)){
                    final Optional<Integer> pairIndex = findPairIndex(right, i, mapIndex);
                    if(pairIndex.isPresent()){
                        result.add(Arrays.asList( pairIndex.get(), i));
                    }
                }
                if(isPalindrome(right)){
                    final Optional<Integer> pairIndex = findPairIndex(left, i, mapIndex);
                    if(pairIndex.isPresent()){
                        result.add(Arrays.asList( i, pairIndex.get()));
                    }
                }

            }
        }

        return result;
    }

    private static Optional<Integer> findPairIndex(String word, Integer wordIndex, Map<String, Integer> mapIndex){
        final String reverseWord = "".equals(word)? "" : new StringBuilder(word).reverse().toString();
        if(mapIndex.containsKey(reverseWord)){
            final Integer reverseWordIndex = mapIndex.get(reverseWord);
            if(!Objects.equals(reverseWordIndex, wordIndex)){
                return Optional.of(reverseWordIndex);
            }
        }
        return Optional.empty();
    }

    private static boolean isPalindrome(String word) {
        int i= 0;
        int j = word.length()-1;

        while (i<j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.

     For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd".
     */
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        System.out.println("table:"+Arrays.toString(table));
        System.out.println("temp: "+temp);
        System.out.println("Table last:"+table[table.length - 1]);
        System.out.println("Substring: "+s.substring(table[table.length - 1]));
        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }else{
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];

                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char
                    index ++ ;
                }

                table[i] = index;
            }

        }

        return table;
    }

    public String shortestPalindrome2(String s) {
        if(s.length() <=1) return s;
        String reverse = (new StringBuilder(s)).reverse().toString();
        String target = s + "*" + reverse;
        int[] next = new int[target.length()];
        next[0] = 0;
        for(int i=1; i< target.length(); i++){
            int k = next[i-1];
            while(k>0 && target.charAt(k) != target.charAt(i)) k = next[k-1];
            next[i] = target.charAt(k) == target.charAt(i) ? k+1 : k;
        }

        return reverse.substring(0, reverse.length()-next[target.length()-1]) + s;
    }


    public boolean isPermutationOfPalindrome(String phrase){
        final int bitVector = createBitVector(phrase);
        return bitVector==0 || checkExactlyOneBitSet(bitVector);
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector-1))==0;
    }

    //for each letter toggle the ith letter
    private int createBitVector(String phrase) {
        int bit = 0;

        for (int i = 0; i < phrase.length(); i++) {
            final char c = phrase.charAt(i);
            int number = getCharNumber(c);
            bit = toggle(bit, number);
        }
        return bit;
    }

    private int toggle(int bit, int number) {
        if(number<=-1){
            return bit;
        }
        int mask = 1 << number;
        if((bit & mask)==0){
            bit |= mask;
        }else {
            bit &= ~mask;
        }
        return bit;
    }

    private int getCharNumber(char c) {
        final int a = Character.getNumericValue('a');
        final int z = Character.getNumericValue('z');
        final int num = Character.getNumericValue(c);
        if(a<=num && num<=z){
            return num-a;
        }
        return -1;
    }

}
