package Programmers.Lv2;

import java.util.Locale;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class N진수_게임 {
    public static void main(String[] args) {
        // solution(2, 4, 2, 1);
        solution(16,16,2,1);
    }

    static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder num = new StringBuilder();
        int i = 0;
        while (num.length() < t * m) {
            String s = Integer.toString(i, n);
            num.append(s);
            i++;
        }

        num.insert(0, "+");

        while (answer.length() != t) {
            answer.append(num.charAt(p));
            p += m;
        }

        return answer.toString().toUpperCase(Locale.ROOT);
    }
}
