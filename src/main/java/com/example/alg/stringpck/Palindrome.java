package com.example.alg.stringpck;

public class Palindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters
     * and ignoring cases.

     For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
     */
    public static boolean isValidPalindrome(String s){
        if(s==null || s.length()==0){
            return false;
        }

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
