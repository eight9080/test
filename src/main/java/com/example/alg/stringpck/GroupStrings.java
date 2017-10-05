package com.example.alg.stringpck;

import java.util.*;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

 Given a list of strings which contains only lowercase alphabets, group all strings that belong to
 the same shifting sequence, return:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 */
public class GroupStrings {

    public static List<List<String>> groupStrings(String[] strings) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s: strings){
            final char[] characters = s.toCharArray();
            if(characters.length>0){
                int diff = characters[0]-'a';
                for(int i = 0; i< characters.length; i++){
                    if(characters[i]-diff<'a'){
                        characters[i] = (char)(characters[i]-diff+26);
                    }else{
                        characters[i] = (char)(characters[i]-diff);
                    }
                }
            }


            final String newWord = new String(characters);
            map.putIfAbsent(newWord, new ArrayList<>());
            map.get(newWord).add(s);
        }

        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            Collections.sort(entry.getValue());
        }

        List<List<String>> result = new ArrayList<>();

        result.addAll(map.values());

        return result;
    }

}
