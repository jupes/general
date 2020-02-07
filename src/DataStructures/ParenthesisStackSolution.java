package DataStructures;

// The code below handles the balanced parenthesis problem with a stack

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class ParenthesisStackSolution {
    public static char[][] TOKENS = {{'{', '}'}, {'[', ']'},{'(', ')'}};

    /**
     * Walk through tokens and see if open term, check the first term of each. the first element will be one of the first element in one of the arrays
     * @param c character representing one of the closed or open terms
     * @return if it does not find an opening term return false
     */
    public static boolean isOpen(char c) {
        for (char[] array : TOKENS) {
            if (array[0] == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * check if the open term and closed term are the matches defined in the tokens object
     * @param openTerm 
     * @param closedTerm
     * @return result of a match is the tokens object, return false if not or if characters are not represented in tokens
     */
    public static boolean matches(char openTerm, char closedTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm) {
                return array[1] == closedTerm;
            }
        }
        return false;
    }

    /**
     * Use a stack to push on open terms and pop to check if they match correctly
     * @param expression a string of tokens  ex. ()({[][({})]}) should return true
     * @return result of each term matching up with its counterpart closing term
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !matches(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}