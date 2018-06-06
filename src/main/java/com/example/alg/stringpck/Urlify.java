package com.example.alg.stringpck;

public class Urlify {

    public String replaceSpaces(String str){
        final int realSize = str.trim().length();
        int spaceCount = 0;
        for (int i = 0; i < realSize; i++) {
            if(str.charAt(i)==' '){
                spaceCount++;
            }
        }
        int index = realSize+spaceCount*2;
        final char[] chr = str.toCharArray();
        for (int i = realSize-1; i >=0 ; i--) {
            if(chr[i]==' '){
                chr[index-1]='0';
                chr[index-2]='2';
                chr[index-3]='%';
                index=index-3;
            }else {
                chr[index-1]=chr[i];
                index--;
            }
        }

        return new String(chr);

    }

}
