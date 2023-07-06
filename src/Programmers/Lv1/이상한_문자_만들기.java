package Programmers.Lv1;

import java.util.Arrays;
import java.util.Locale;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        solution("aAa  test             ab ");
    }

    static String solution(String s) {
        String answer = "";

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i-1) == ' ') {
                index = 0;
            }

            String pre = s.substring(0, i);
            String next = s.substring(i+1);
            String current = s.substring(i, i + 1);
            if (index % 2 == 0) {
                s = pre + current.toUpperCase(Locale.ROOT) + next;
            } else {
                s = pre + current.toLowerCase(Locale.ROOT) + next;
            }
            index++;
        }

        System.out.println("answer = " + s);
        return answer;
    }

    static String solution2(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == ' ') {
                index = 0;
                answer.append(' ');
            } else {
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(currentChar));
                } else {
                    answer.append(Character.toLowerCase(currentChar));
                }
                index++;
            }
        }
        System.out.println("answer = " + answer.toString());
        return answer.toString();
    }
}
