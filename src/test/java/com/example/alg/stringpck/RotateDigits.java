package com.example.alg.stringpck;

import java.util.HashSet;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

 A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

 Now given a positive number N, how many numbers X from 1 to N are good?

 Example:
 Input: 10
 Output: 4
 Explanation:
 There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 */
public class RotateDigits {

    public int rotatedDigits(int N) {

        HashSet<Character> valid = new HashSet<>();
        valid.add('2');
        valid.add('5');
        valid.add('6');
        valid.add('9');
        HashSet<Character> invalid = new HashSet<>();
        invalid.add('3');
        invalid.add('4');
        invalid.add('7');
        HashSet<Character> same = new HashSet<>();
        same.add('0');
        same.add('1');
        same.add('8');
        int invalidCount = 0;
        for (int i = 1; i <= N ; i++) {

            final String s = String.valueOf(i);
            int notChanged = 0;
            for (int j = 0; j < s.length(); j++) {
                final char c = s.charAt(j);
                if(invalid.contains(c)){
                    invalidCount++;
                    break;
                }
                if(same.contains(c)){
                    notChanged++;
                }
                if(notChanged==s.length()){
                    invalidCount++;
                }
            }

        }

        return N-invalidCount;

    }
}
