package com.example.alg.stringpck;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJava8 {

    public static String join(String[] arraryOfStrings){
        return Arrays.stream(arraryOfStrings).collect(Collectors.joining(","));
    }

    public static String joinWithPrefixPostfix(String[] arraryOfStrings){
        return Arrays.stream(arraryOfStrings).collect(Collectors.joining(",", "[", "]"));
    }

    public static List<Character> splitToListOfChar(String str){
       return str.chars().mapToObj(item -> (char)item)
                .collect(Collectors.toList());

    }

    public static List<String> split(String str){
        return Stream.of(str.split(","))
                .map(String::new)
                .collect(Collectors.toList());
    }
}