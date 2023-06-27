package Programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */
public class 둘만의_암호 {
    public static void main(String[] args) {
        String s = "z";
        String skip = "abcdefghij";
        int index = 20;
        solution(s, skip, index);
    }

    static String solution(String s, String skip, int index) {
        String answer = "";

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        int length = alphabet.length - skip.length();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Integer, Character> map2 = new HashMap<>();
        int i = 1;
        for (char c : alphabet) {
            if (skip.contains(String.valueOf(c))) {
                continue;
            }
            map1.put(c, i);
            map2.put(i, c);
            i++;
        }

        for (int j = 0; j < s.length(); j++) {
            int num = map1.get(s.charAt(j)) + index;
            while (num > length) {
                num = num - length;
            }

            System.out.println("num = " + num);
            answer += map2.get(num);
        }
        System.out.println("answer = " + answer);

        return answer;
    }

}
