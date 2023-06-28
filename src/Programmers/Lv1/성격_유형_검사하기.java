package Programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class 성격_유형_검사하기 {
    public static void main(String[] args) {
        String[] survey = {"RT", "RT", "RT","RT", "RT", "RT","RT", "RT", "RT"};
        int[] choices = {7, 2, 4,7, 2, 4,7, 2, 4};
        solution(survey, choices);
    }

    static Map<Character, Integer> map = new HashMap<>();
    static String solution(String[] survey, int[] choices) {
        String answer = "";

        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        char c;
        // 1,2,3 왼쪽 5,6,7 오른쪽
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) { // 오른쪽
                c = survey[i].charAt(1);
            } else {
                c = survey[i].charAt(0);
            }
            int score = map.get(c);
            map.put(c, score + converter(choices[i]));
        }

        answer += compare('R', 'T');
        answer += compare('C', 'F');
        answer += compare('J', 'M');
        answer += compare('A', 'N');

        System.out.println("map = " + map);
        System.out.println("answer = " + answer);

        return answer;
    }

    private static int converter(int num) {
        if (num == 3 || num == 5) {
            num = 1;
        } else if (num == 2 || num == 6) {
            num = 2;
        } else if (num == 1 || num == 7) {
            num = 3;
        } else {
            num = 0;
        }

        return num;
    }

    private static char compare(char a, char b) {
        int x = map.get(a);
        int y = map.get(b);
        if (x >= y) {
            return a;
        }
        return b;
    }
}
