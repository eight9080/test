package com.example.alg.stringpck;

public class UniqueStrings {

    public boolean isUniqueChars(String text){
        if(text.length()>128){
            return false;
        }

        boolean[] charactersFound = new boolean[128];
        for (int i = 0; i < text.length(); i++) {
            final char character = text.charAt(i);
            if(charactersFound[character]){
                return false;
            }
            charactersFound[character]=true;
        }
        return true;
    }


}
