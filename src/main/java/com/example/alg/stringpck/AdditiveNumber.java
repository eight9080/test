package com.example.alg.stringpck;

import java.util.ArrayList;

/**
 * Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {

        if(num==null || num.isEmpty()){
            return false;
        }

//        if(num.startsWith("0")){
//            return false;
//        }
        int offset=1;
        while (offset<=num.length()/2){
            if (num.charAt(0) == '0' && offset > 1) return false;
            final Long firstNumber = new Long(num.substring(0, offset));
            for (int i = 1; i <= num.length()-offset-i; ++i) {
                if (num.charAt(offset) == '0' && i > 1) break;
                final Long secondNumber = new Long(num.substring(offset, offset+i));
                if(checkSequence(num, offset+i, firstNumber,secondNumber)){
                    return true;
                }
            }
            offset++;
        }

        return false;
    }

    private boolean checkSequence(String num, int i, Long firstNumber, Long secondNumber) {

        long nextFirstNumber = firstNumber;
        long nextSecondNumber = secondNumber;
        String nextNumberStr;
        for (int j = i; j < num.length(); j+=nextNumberStr.length()) {
            nextSecondNumber = nextFirstNumber+nextSecondNumber;
            nextFirstNumber = nextSecondNumber-nextFirstNumber;
            nextNumberStr = String.valueOf(nextSecondNumber);
            if(!num.startsWith(nextNumberStr, j)){
                return false;
            }
        }

        return true;
    }

}
