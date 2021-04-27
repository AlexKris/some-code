package com.chris.some.code.leetcode.y2021.m04.d06;

import java.util.HashMap;
import java.util.Stack;

/**
 * 问题20
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * <pre>
 *     1. 左括号必须用相同类型的右括号闭合。
 *     2. 左括号必须以正确的顺序闭合。
 * </pre>
 *
 * @author grt
 */
public class Q20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;
        // 括号之间的对应规则
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(chars[i])) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
