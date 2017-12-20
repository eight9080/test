package com.example.alg.dynamic;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
     * <p>
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     * <p>
     * Return true because "leetcode" can be segmented as "leet code".
     * <p>
     * UPDATE (2017/1/4):
     * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean[] validWords = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(wordDict.contains(s.substring(0, i+1))){
                validWords[i]=true;
            }
            if(validWords[i] && i==n-1){
                return true;
            }
            if(validWords[i]){
                for(int j=i+1;j<n;j++ ){
                    final String part = s.substring(i + 1, j + 1);
                    if(wordDict.contains(part)){
                        validWords[j]=true;
                    }
                    if(j==n-1 && validWords[j]){
                        return true;
                    }

                }
            }
        }

        return false;
    }


    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

     Return all such possible sentences.

     For example, given
     s = "catsanddog",
     dict = ["cat", "cats", "and", "sand", "dog"].

     A solution is ["cats and dog", "cat sand dog"].

     UPDATE (2017/1/4):
     The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {

        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<>();

        for(int i=0; i<s.length(); i++){

            if(pos[i]==null)
                continue;

            for(int j=i+1; j<=s.length(); j++){
                final String word = s.substring(i, j);
                if(wordDict.contains(word)){
                    if(pos[j]==null){
                        pos[j]=new ArrayList<>();
                    }
                    pos[j].add(word);
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<>();
        }
        
        ArrayList<String> result = new ArrayList<>();
        dfs(pos, result, "", s.length());
        return result;


    }

    private void dfs(ArrayList<String>[] pos, ArrayList<String> result, String phrase, int length) {
        if(length<=0){
            result.add(phrase.trim());
            return;
        }

        for (String word: pos[length]) {
            String newPhrase=word+" "+phrase;
            dfs(pos, result, newPhrase, length-word.length());
        }

    }


}
