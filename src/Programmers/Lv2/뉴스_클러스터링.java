package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class 뉴스_클러스터링 {
    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";
        solution(str1, str2);
    }
    /*
        두 글자씩 끊어서 만들기
        공백이나 숫자, 특수 문자는 버리기 (정규식 쓰면 될 듯)
        마지막 65536 곱하기
        문제 잘 읽기!! -> "ab+" 라면 "b+" 버림!
     */
    static int solution(String str1, String str2) {
        int answer = 0;
        // 특수 문자 제거
        // str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        // str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        int len1 = str1.length();
        int len2 = str2.length();
        double intersection = 0;
        double union = 0;

        for (int i = 0; i < len1-1; i++) {
            String s1 = str1.substring(i, i+2);
            if (s1.matches("[a-zA-Z]{2}")) {
                map1.put(s1, map1.getOrDefault(s1, 0)+1);
                union++;
            }

        }

        for (int i = 0; i < len2-1; i++) {
            String s2 = str2.substring(i, i+2);
            if (s2.matches("[a-zA-Z]{2}")) {
                map2.put(s2, map2.getOrDefault(s2, 0)+1);
                union++;
            }
        }

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                // 개수 비교 합집합은 작은 개수
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        union = union - intersection;
        if (union == 0) {
            answer = 65536;
        } else {
            answer = (int) (intersection / union * 65536);
        }


        System.out.println("intersection = " + intersection);
        System.out.println("union = " + union);
        System.out.println("map1 = " + map1);
        System.out.println("map2 = " + map2);
        System.out.println("answer = " + answer);
        return answer;
    }
}
