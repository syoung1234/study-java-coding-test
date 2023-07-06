package Programmers.Lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 * 하루종일 해서 품....
 * - 는 0으로 치환해서 풀면 편함 (연산자 -가 아님)
 * 예) -300*-220 -> 0300*0220 -> calculate 에서 0은 - 로 치환
 */
public class 수식_최대화 {
    public static void main(String[] args) {
        // solution("100-200*300-500+20");
        solution("50*6-3*2");
    }

    // 연산자 우선순위 재정의하여 만들 수 있는 가장 큰 숫자 제출
    // 우선 순위 조합 2개면 2! 3개면 3!
    // 같은 순위 연산자는 없음
    // - 는 절대값으로 변환
    // 절대값이니까 음수가 가장 커도 됨
    // 가장 큰 수 return
    // 3 <= expression <= 100
    // 0 <= operand <= 999
    // long 타입
    static ArrayList[] priority;
    static long solution(String expression) {
        long answer = 0;
        String[] priority = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
        String ex;

        for (String pri : priority) {
            ex = expression;
            char[] chars = pri.toCharArray();
            for (char c : chars) {
                if (ex.indexOf(c) < 0) {
                    continue;
                }
                int index = ex.indexOf(c, 1);
                int i = index - 1, j = index + 1;
                boolean left = true, right = true;
                String a = "", b = "";
                String calculate = "";

                while (left || right) {
                    if (i >= 0 && Character.isDigit(ex.charAt(i))) {
                        a = ex.charAt(i) + a;
                        i--;
                    }
                    else left = false;
                    if (j < ex.length() && Character.isDigit(ex.charAt(j))) {
                        b = b + ex.charAt(j);
                        j++;
                    }
                    else right = false;

                    if (!left && !right) {
                        // 수식 끝
                        calculate = calculate(a, b, c);
                        ex = ex.replace(a + c + b, calculate);
                        if (ex.indexOf(c, 1) > 0) {
                            index = ex.indexOf(c, 1);
                            i = index - 1;
                            j = index + 1;
                            left = true; right = true;
                            a = ""; b = "";
                        }
                    }
                }

            }
            answer = Math.max(Math.abs(Long.parseLong(ex)), answer);
        }

        System.out.println("max = " + answer);

        return answer;
    }

    static String calculate(String l, String r, Character operator) {
        long a = Long.parseLong(l);
        long b = Long.parseLong(r);
        long cal;

        // 마이너스 연산자
        if (l.charAt(0) == '0') a *= -1;
        if (r.charAt(0) == '0') b *= -1;

        String result;
        if (operator == '+') {
            cal = a + b;
        } else if (operator == '-') {
            cal = a - b;
        } else {
            cal = a * b;
        }
        result = String.valueOf(cal);
        if (cal < 0) {
            result = result.replace('-', '0');
        }
        return result;
    }

}


