package com.example.alg.mathpck;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 */
public class ConvertNumberToHex {

    public String toHex(int num) {
        if(num==0) return "0";

        final StringBuilder result = new StringBuilder();
        while (num!=0){
            int part = num & 15 ; //to get hex for last 4 bits of num, use mask 15, which is '1111' in bits
            if(part<=9){
                result.append(part);
            }else {
                result.append((char)('a'+(part-10)));
            }
            num = num >>> 4; ////unsigned right shift 4 bits to get next 4 bits of num in hex
        }

        return result.reverse().toString();


    }
}
