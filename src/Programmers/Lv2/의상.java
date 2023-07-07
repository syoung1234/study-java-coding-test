package Programmers.Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 경우의 수
 */
public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}, {"yellow_hat1", "headgear"},
                {"yellow_hat2", "headgear"}, {"crow_mask", "face"},
                {"crow_mask2", "face"},
        };
        solution(clothes);
    }

    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }

        // 옷을 입지 않는 경우 1개 추가
        for (int v : map.values()) {
            answer *= (v+1);
        }

        System.out.println("answer = " + (answer-1));
        return answer-1;
    }

}
