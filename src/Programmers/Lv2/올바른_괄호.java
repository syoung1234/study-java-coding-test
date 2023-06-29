package Programmers.Lv2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class 올바른_괄호 {
    public static void main(String[] args) {
        solution("((()()))");
    }

    static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
