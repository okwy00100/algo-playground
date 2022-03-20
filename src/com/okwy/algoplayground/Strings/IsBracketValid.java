package com.okwy.algoplayground.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsBracketValid {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     */

    private static boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');

        for(char c : s.toCharArray()){
            if(brackets.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                if(brackets.get(stack.pop()) != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()()(())";

        System.out.println(">>>>>>Is Bracket Valid>>>>> " + s + " >>>>>>" + isValid(s));
    }
}
