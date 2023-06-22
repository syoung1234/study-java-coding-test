package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 */
public class 가장_가까운_같은_글자 {
    public static void main(String[] args) {
        solution("banana");
    }

    static int[] solution(String s) {
        int[] answer = {};
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        answer = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            int num = map.getOrDefault(chars[i], -1);
            answer[i] = num;

            if (num >= 0) {
                answer[i] = i - num;
            }
            map.put(chars[i], i);

        }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
}
