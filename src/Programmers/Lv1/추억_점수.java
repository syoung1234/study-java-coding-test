package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
public class 추억_점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"},
        };

        solution(name, yearning, photo);
    }

    static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int sum;
        for (int i = 0; i < photo.length; i++) {
            sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                Integer score = map.getOrDefault(photo[i][j], 0);
                sum += score;
            }
            answer[i] = sum;
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}
