package com.example.alg.stringpck;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

 For example, with A = "abcd" and B = "cdabcdab".

 Return 3, because by repeating A three times (“abcdabcdabcd”),
 B is a substring of it; and B is not a substring of A
 repeated two times ("abcdabcd").
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {

        int count = 1;
        StringBuilder temp = new StringBuilder(A);
        while (temp.length()<B.length()){
            temp.append(A);
            count++;
        }
        if(temp.indexOf(B)!=-1){
            return count;
        }
        temp.append(A);
        if(temp.indexOf(B)==-1){
            return -1;
        }
        count++;
        return count;
    }

}
