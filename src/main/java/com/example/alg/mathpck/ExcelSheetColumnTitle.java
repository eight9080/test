package com.example.alg.mathpck;

public class ExcelSheetColumnTitle {

    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     */
    public String convertToTitle(int n) {

        StringBuilder result = new StringBuilder();

        while (n>0){
            n--;
            final int offset = (n) % 26;
            final char letter = (char)('A' + offset);
            result.append(letter);

            n = n/26;
        }
        return result.reverse().toString();

    }

    /**
     * Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     */
    public int titleToNumber(String s) {

        if(s==null || s.length() == 0){
            throw new IllegalArgumentException("Not valid!");
        }

        int result = 0;
        int indexLetter = s.length()-1;
        int t = 0;
        while(indexLetter >= 0){
            char currentLetter = s.charAt(indexLetter);
            result = result + (int) Math.pow(26, t) * (currentLetter-'A'+1);
            t++;
            indexLetter--;
        }

        return result;
    }


}
