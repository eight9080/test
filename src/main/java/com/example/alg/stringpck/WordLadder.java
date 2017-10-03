package com.example.alg.stringpck;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        final LinkedList<WordNode> wordNodes = new LinkedList<>();
        wordNodes.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while (!wordNodes.isEmpty()) {
            System.out.println("Starting: " + wordNodes);
            final WordNode top = wordNodes.remove();

            String word = top.word;
            if (word.equals(endWord)) {
                return top.numSteps;
            }

            final char[] chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                for (char c = 'a'; c < 'z'; c++) {
                    char temp = chars[i];
                    if (chars[i] != c) {
                        chars[i] = c;
                        final String newWord = new String(chars);
//                        System.out.println("New words try: " + newWord);
                        if (wordDict.contains(newWord)) {
//                            System.out.println("New words found: " + newWord);
                            wordNodes.add(new WordNode(newWord, top.numSteps + 1));
                            wordDict.remove(newWord);
//                            System.out.println("Finishing: " + wordNodes);
                        }
                        chars[i] = temp;
                    }

                }
            }

        }
        return 0;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        final List<List<String>> result = new ArrayList<>();
        final LinkedList<WordNode> wordNodes = new LinkedList<>();
        wordNodes.add(new WordNode(start,1, null));

        dict.add(end);
        int minStep = 0;

        final HashSet<String> visited = new HashSet<>();
        final HashSet<String> unvisited = new HashSet<>();
        unvisited.addAll(dict);

        int preNumSteps = 0;
        while (!wordNodes.isEmpty()){
            WordNode top = wordNodes.remove();
            final String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(end)){
                if(minStep==0){
                    minStep= top.numSteps;
                }
                if(top.numSteps==minStep && minStep!=0){
                    final ArrayList<String> t = new ArrayList<>();
                    t.add(top.word);
                    while (top.pre!=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }

            if(preNumSteps<currNumSteps){
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            final char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char c = 'a'; c < 'z'; c++) {
                    char temp = chars[i];
                    if (chars[i] != c) {
                        chars[i] = c;
                        final String newWord = new String(chars);
                       // System.out.println("New words try: " + newWord);
                        if (unvisited.contains(newWord)) {
                            System.out.println("New words found: " + newWord);
                            wordNodes.add(new WordNode(newWord, top.numSteps + 1, top));
                            visited.add(newWord);
                            System.out.println("Finishing: " + wordNodes);
                        }
                        chars[i] = temp;
                    }

                }
            }

        }
        return result;
    }

    private static class WordNode {
        String word;
        int numSteps;
        WordNode pre;

        public WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }

        public WordNode(String word, int numSteps, WordNode pre) {
            this.word = word;
            this.numSteps = numSteps;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "WordNode{" +
                    "word='" + word + '\'' +
                    ", numSteps=" + numSteps +
                    '}';
        }
    }
}
