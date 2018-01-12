package com.example.alg.permutations;

import com.example.alg.stringpck.IntegerToEnglish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPAddresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

     For example:
     Given "25525511135",

     return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */
    public List<String> restoreIpAddresses(String s) {

        if(s==null || s.isEmpty()){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        dfs(s, 0,  0, "", result );

        return result;

    }

    private void dfs(String ip, int index,  int count, String current, List<String> result) {
        if(count>4) return;
        if(count==4 && index==ip.length()){
            result.add(current);
            return;
        }

        for(int i = 1; i<=3; i++){
            if(index+i>ip.length())
                continue;
            final String part = ip.substring(index, index + i);
            if(!isValid(part)){
                continue;
            }
            String suffix = count==3? "":".";
            dfs(ip, index+i, count+1, current+part+suffix, result);

        }

    }

    private boolean isValid(String text){
        if(text.startsWith("0") && text.length()>1){
            return false;
        }
        if(text.length()==3 && Integer.parseInt(text)>=256){
            return false;
        }
        return true;
    }

}
