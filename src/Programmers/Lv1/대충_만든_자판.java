package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
public class 대충_만든_자판 {
    public static void main(String[] args) {
        String[] keymap = {"A"};
        String[] targets = {"B", "C"};
        solution(keymap, targets);
    }

    static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Long> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            char[] chars = keymap[i].toCharArray();
            Long index = 0L;

            for (Character c : chars) {
                index++;
                Long num = map.getOrDefault(c, -1L);

                if (num == -1L || num > index) {
                    map.put(c, index);
                }

            }
        }

        int count;
        for (int i = 0; i < targets.length; i++) {
            count = 0;
            char[] targetChars = targets[i].toCharArray();

            for (Character targetC : targetChars) {
                Long targetNum = map.getOrDefault(targetC, -1L);
                if (targetNum == -1) {
                    count = -1;
                    break;
                }
                count += targetNum;
            }

            if (count == -1) {
                answer[i] = -1;
            }


            answer[i] = count;
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}
