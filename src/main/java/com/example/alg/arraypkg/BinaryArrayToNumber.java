package com.example.alg.arraypkg;

import java.util.List;

public class BinaryArrayToNumber {

    /**
     * Given an array of one's and zero's convert the equivalent binary value to an integer.

     Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1

     Examples:

     Testing: [0, 0, 0, 1] ==> 1
     Testing: [0, 0, 1, 0] ==> 2
     Testing: [0, 1, 0, 1] ==> 5
     Testing: [1, 0, 0, 1] ==> 9
     Testing: [0, 0, 1, 0] ==> 2
     Testing: [0, 1, 1, 0] ==> 6
     Testing: [1, 1, 1, 1] ==> 15
     Testing: [1, 0, 1, 1] ==> 11
     */
    public static int convertBinaryArrayToInt(List<Integer> binary) {
//        return binary.stream().reduce((x, y) -> x * 2 + y).get();
        if(binary==null || binary.isEmpty()){
            return 0;
        }
        int result = 0;
        int base = 2;
        for (int i = 0; i < binary.size(); i++) {
            final Integer value = binary.get(i);
            if(value!=0) {
                result+= (int) (value * Math.pow(base, binary.size() - (i + 1)));
            }
        }
        return result;
    }
}
