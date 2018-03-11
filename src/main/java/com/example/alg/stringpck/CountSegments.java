package com.example.alg.stringpck;

public class CountSegments {

    /**
     * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

     Please note that the string does not contain any non-printable characters.

     Example:

     Input: "Hello, my name is John"
     Output: 5
     */
    public int countSegments(String s) {

        if(s==null ){
            return 0;
        }

        final String input = s.trim();

        if(input.length()==0){
            return 0;
        }

        final String[] parts = input.split("\\s+");

        return parts.length;

    }
}
