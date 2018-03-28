package com.example.alg.stringpck;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
    /**
     * Given a string which contains only lowercase letters,
     * remove duplicate letters so that every letter
     * appear once and only once.
     * You must make sure your result is the smallest
     * in lexicographical order among all possible results.

     Example:
     Given "bcabc"
     Return "abc"

     Given "cbacdcbc"
     Return "acdb"
     */
    public String removeDuplicateLetters(String s) {

        if(s==null || s.length()==0){
            return s;
        }


        final Map<Character, Long> lettersFreq = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Boolean> visited = new HashMap<>();

        Deque<Character> stack = new ArrayDeque<>();
        final char[] chars = s.toCharArray();
        for (char c : chars) {
            lettersFreq.computeIfPresent(c, (c1, v) -> v-1);
            if(visited.getOrDefault(c, false)){
                continue;
            }
            while (!stack.isEmpty()){
                final Character letterInStack = stack.peek();
                if(letterInStack <c || lettersFreq.get(letterInStack)==0){
                    break;
                }
                visited.put(letterInStack, false);
                stack.pop();
            }

            stack.push(c);
            visited.put(c, true);
        }


        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty()){
            temp.append(stack.pollLast());
        }
        return temp.toString();
    }
}
