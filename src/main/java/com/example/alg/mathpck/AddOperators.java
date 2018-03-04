package com.example.alg.mathpck;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 */
public class AddOperators {

    public List<String> addOperators(String num, int target) {
        if(num==null || num.isEmpty()){
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        addOperatorsHelper(num, target, 0, result,
                new StringBuilder(), 0, 0 );

        return result;

    }

    private void addOperatorsHelper(String num, int target,
                                                    int position, List<String> result,
                                                    StringBuilder currentPath,
                                                    long prev, long previousNumber) {
        if(position==num.length()){
            if(target==prev){
                result.add(currentPath.toString());
                return;
            }
        }

        for (int i = position; i < num.length(); i++) {
            final char c = num.charAt(position);

            if(c=='0' && i !=position){
                break;
            }
            final long currentNumber = Long.parseLong(num.substring(position, i + 1));
            final int length = currentPath.length();

            if(position==0){
                addOperatorsHelper(num, target, i+1, result,
                        currentPath.append(currentNumber), currentNumber, currentNumber);
                currentPath.setLength(length);
                continue;
            }
            //+
            addOperatorsHelper(num, target, i+1,
                    result, currentPath.append("+").append(currentNumber), currentNumber+prev, currentNumber);
            currentPath.setLength(length);
            //-
            addOperatorsHelper(num, target, i+1,
                    result, currentPath.append("-").append(currentNumber), prev-currentNumber, -currentNumber);
            currentPath.setLength(length);
            //*
            addOperatorsHelper(num, target, i+1,
                    result, currentPath.append("*").append(currentNumber),
                    prev - previousNumber + previousNumber * currentNumber, previousNumber*currentNumber);
            currentPath.setLength(length);

        }

    }
}
