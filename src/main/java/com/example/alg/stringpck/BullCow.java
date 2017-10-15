package com.example.alg.stringpck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullCow {

    /**
     * You are playing the following Bulls and Cows game with your friend:
     * You write down a number and ask your friend to guess what the number is.
     * Each time your friend makes a guess, you provide a hint that indicates
     * how many digits in said guess match your secret number exactly in both digit and position
     * (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
     * Your friend will use successive guesses and hints to eventually derive the secret number.
     * <p>
     * For example:
     * <p>
     * Secret number:  "1807"
     * Friend's guess: "7810"
     * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
     * Write a function to return a hint according to the secret number and friend's guess,
     * use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
     * <p>
     * Please note that both secret number and friend's guess may contain duplicate digits, for example:
     * <p>
     * Secret number:  "1123"
     * Friend's guess: "0111"
     * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and
     * your function should return "1A1B".
     * You may assume that the secret number and your friend's guess only contain digits, and
     * their lengths are always equal.
     */
    public String getHint(String secret, String guess) {

        Map<Character, List<Integer>> secretLettersByPosition = new HashMap<>();
        boolean[] guessedLetters = new boolean[secret.length()];
        int correctGuesses = 0;
        for (int i = 0; i < secret.length(); i++) {
            final char secretLetter = secret.charAt(i);
            if (guess.charAt(i) == secretLetter) {
                guessedLetters[i] = true;
                correctGuesses++;
            } else {
                secretLettersByPosition.putIfAbsent(secretLetter, new ArrayList<>());
                secretLettersByPosition.get(secretLetter).add(i);
            }

        }
        StringBuilder result = new StringBuilder("" + correctGuesses + "A");
        if (correctGuesses == secret.length()) {
            result.append("0B");
            return result.toString();
        }
        int noCows = 0;
        for (int i = 0; i < guessedLetters.length; i++) {
            if (guessedLetters[i]) continue;
            final char guessLetter = guess.charAt(i);
            final List<Integer> positions = secretLettersByPosition.get(guessLetter);
            if (positions != null && !positions.isEmpty()) {
                positions.remove(0);
                noCows++;
            }
        }

        result.append("" + noCows + "B");
        return result.toString();
    }

}
