package com.example.alg.stringpck;

public class Permutation {

    public boolean permutation(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        return  sortString(str1).equals(sortString(str2));
    }


    private String sortString(String str){
        final String value = str.chars().sorted().map(c -> (char) c).collect(StringBuilder::new,
                (sb, c) -> sb.append((char) c), StringBuilder::append).toString();
        return value;
    }


    //count letters
    public boolean permutation2(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }

        int[] charsNo = new int[128];

        str1.chars().forEach(i -> charsNo[i]++);

        for (int i = 0; i < str2.length(); i++) {
            final int index = str2.charAt(i);
            charsNo[index]--;
            if(charsNo[index]<0){
                return false;
            }
        }
        return true;
    }

}
