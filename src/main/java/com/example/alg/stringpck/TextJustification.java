package com.example.alg.stringpck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }

        int remainingLength = maxWidth;
        List<String> row = new ArrayList<>();
        int normalSpacesInRow = 0;
        for (int i = 0; i < words.length; i++) {
            int wordL = words[i].length();
            if(row.isEmpty()){
                remainingLength -= wordL;
            }else {
                remainingLength -= wordL+1;
                normalSpacesInRow++;
            }
            if(remainingLength>0){
                row.add(words[i]);
                continue;
            }
            if(remainingLength<0){
                //add new row
                remainingLength += wordL+1;
                normalSpacesInRow--;
                //normalSpacesInRow = row.size()-1;
                int eqExtraSpace = 0;
                int extraSpaceLength=0;
                    eqExtraSpace = remainingLength/normalSpacesInRow;
                    extraSpaceLength = remainingLength - normalSpacesInRow * eqExtraSpace;
                final StringBuilder rowResult = new StringBuilder();
                for (int j = 0; j < row.size(); j++) {
                    rowResult.append(row.get(j));
                    if(j<row.size()-1) {
                        int noSpacesToBeAdded = eqExtraSpace+1;
                        if (extraSpaceLength > 0) {
                            noSpacesToBeAdded++;
                            extraSpaceLength--;
                        }
                        rowResult.append(String.join("", Collections.nCopies(noSpacesToBeAdded, " ")));
                    }
                }
                result.add(rowResult.toString());
                row.clear();
                remainingLength = maxWidth;
            }
            if(remainingLength==0){
                row.add(words[i]);
                final StringBuilder rowResult = new StringBuilder();
                for (int j = 0; j < row.size(); j++) {
                    rowResult.append(row.get(j));
                    if(j<row.size()-1) {
                        rowResult.append(" ");
                    }
                }
                result.add(rowResult.toString());
                row.clear();
                remainingLength = maxWidth;
            }
            row.add(words[i]);
            remainingLength-=wordL;
            normalSpacesInRow=0;

        }
        if(row.size()>0){
            final StringBuilder rowResult = new StringBuilder();
            for (int j = 0; j < row.size(); j++) {
                rowResult.append(row.get(j));
                if(j<row.size()-1) {
                    rowResult.append(" ");
                }
            }
            int noSpacesToBeAdded = maxWidth-rowResult.length();
            rowResult.append(String.join("", Collections.nCopies(noSpacesToBeAdded, " ")));
            result.add(rowResult.toString());
        }

        return result;
    }





    public static List<String> fullJustifyS(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();

        if(words==null || words.length==0){
            return result;
        }


        int count=0;
        int last=0;
        for(int i=0; i<words.length; i++){
            count = count + words[i].length();

            if(count+i-last>maxWidth){
                int wordsLen = count-words[i].length();
                int spaceLen = maxWidth-wordsLen;
                int eachLen = 1;
                int extraLen = 0;

                if(i-last-1>0){
                    eachLen = spaceLen/(i-last-1);
                    extraLen = spaceLen%(i-last-1);
                }

                StringBuilder sb = new StringBuilder();

                for(int k=last; k<i-1; k++){
                    sb.append(words[k]);

                    int ce = 0;
                    while(ce<eachLen){
                        sb.append(" ");
                        ce++;
                    }

                    if(extraLen>0){
                        sb.append(" ");
                        extraLen--;
                    }
                }

                sb.append(words[i-1]);//last words in the line
                //if only one word in this line, need to fill left with space
                while(sb.length()<maxWidth){
                    sb.append(" ");
                }

                result.add(sb.toString());

                last = i;
                count=words[i].length();
            }
        }

        int lastLen = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=last; i<words.length-1; i++){
            count = count+words[i].length();
            sb.append(words[i]+" ");
        }

        sb.append(words[words.length-1]);
        int d=0;
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        result.add(sb.toString());

        return result;
    }
}