package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
public class 달리기_경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        solution(players, callings);
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int index = map.get(name);
            String temp = players[index-1];
            players[index-1] = name;
            players[index] = temp;

            map.put(name, index-1);
            map.put(temp, index);
        }

        System.out.println("Arrays.toString(players) = " + Arrays.toString(players));


        return answer;
    }
}
