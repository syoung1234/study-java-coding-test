package Programmers.Lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 * 못 품
 */
public class 수식_최대화 {
    public static void main(String[] args) {
        solution("100-200*300+324+234234-234234*100-200*300+324+234234-234234");
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
                int i = ex.indexOf(c,1) - 1;
                int j = ex.indexOf(c, 1) + 1;
                System.out.println("iii = " + i);
                if (c == '*') {
                    if (ex.charAt(j) == '-') {
                        j = j + 1;
                    }
                }
                if (i < 0 || j >= ex.length()) continue;

                String a = "";
                String b = "";
                boolean left = true, right = true;
                // 앞 뒤로 더하기
                while (true) {
                    System.out.println("i = " + i);
                    if (i >= 0 && left && Character.isDigit(ex.charAt(i))) {
                        a += ex.charAt(i);
                        i--;
                        if (i < 0) {
                            left = false;
                        }
                    } else {
                        left = false;
                    }

                    if (j < ex.length() && Character.isDigit(ex.charAt(j))) {
                        b += ex.charAt(j);
                        j++;
                    } else {
                        right = false;
                    }

                    if (!left && !right) {
                        String re = "";
                        for (int k = i+1; k < j; k++) {
                            re += ex.charAt(k);
                        }

                        String[] s = re.split(String.valueOf("\\"+c));
                        System.out.println("re = " + re);
                        System.out.println("s[ = " + Arrays.toString(s));
                        String calculate;
                        if (i == 0 && ex.charAt(i) == '-') {
                            System.out.println("ex.chatAT = " + ex.charAt(i));
                            System.out.println("c = " + c);
                            if (c == '-') calculate = calculate(s[0], s[1], '+')+"";
                            else calculate = calculate(s[0], s[1], c)+"";
                        } else {
                            calculate = calculate(s[0], s[1], c)+"";
                        }

                        System.out.println("c = " + c);
                        System.out.println("calculate = " + calculate);
                        ex = ex.replace(re, calculate);
                        System.out.println("ex = " + ex);
                        System.out.println("j = " + j);
                        if (ex.indexOf(c, 1) > 0) {
                            i = ex.indexOf(c, 1) - 1;
                            j = ex.indexOf(c, 1) + 1;
                            a = "";
                            b = "";
                            left = true;
                            right = true;
                            if (!Character.isDigit(ex.charAt(i))) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            if(ex.charAt(0) == '-') {
                ex = ex.substring(1);
            }
            answer = Math.max(Math.abs(Long.parseLong(ex)), answer);
        }

        System.out.println("max = " + answer);

        return answer;
    }

    static long calculate(String l, String r, Character operator) {
        long a = Long.parseLong(l);
        long b = Long.parseLong(r);
        long result;
        if (operator == '+') {
            result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else {
            result = a * b;
        }
        return result;
    }
}


