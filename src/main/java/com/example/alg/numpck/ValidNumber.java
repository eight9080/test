package com.example.alg.numpck;

public class ValidNumber {
    /**
     * Validate if a given string is numeric.

     Some examples:
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     */
    public boolean isNumber(String s) {

        if(s==null || s.isEmpty()){
            return false;
        }

        final String input = s.trim();
        if(input.isEmpty()){
            return false;
        }

        Double intPart=null;
        Double fractPart = null;
        boolean isFractional=false;
        boolean isScientific=false;
        int i=0;
        final char startC = input.charAt(i);
        if(startC=='-' || startC=='+'){
            i++;
        }
        for (; i < input.length(); i++) {
            final char c = input.charAt(i);
            final boolean lastCharacter = i == input.length() - 1;
            if(c==' '){
                return false;
            }

            if(c=='.'){
                if(isFractional || isScientific){
                    return false;
                }
                if(intPart==null && lastCharacter){
                    return false;
                }

                isFractional=true;
                continue;
            }

            final boolean isDigit = c >= '0' && c <= '9';
            if(isDigit && !isFractional){
                intPart=intPart!=null?intPart:0d*10+ c-'0';
                continue;
            }
            if(isDigit && isFractional){
                fractPart=fractPart!=null?fractPart:0d*10+ c-'0';
                continue;
            }

            if(c=='e' || c=='E'){
                if(isScientific || (intPart==null&&fractPart==null) || lastCharacter){
                    return false;
                }
                isScientific=true;
                continue;
            }

            if(c=='+' ||c=='-'){
                final char prevCharacter = input.charAt(i - 1);
                if(!(prevCharacter=='e' || prevCharacter=='E')){
                    return false;
                }
                if(lastCharacter){
                    return false;
                }
                continue;
            }

                return false;


        }

        return true;

    }
}
