package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12933
 */
public class 정수_내림차순으로_배치하기 {
    public static void main(String[] args) {
        // solution(118372);
        solution2(118372);
    }

    static long solution(long n) {
        long answer = 0;

        String s = String.valueOf(n);
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arrayList.add(s.charAt(i));
        }
        arrayList.sort(Collections.reverseOrder());

        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            str += arrayList.get(i);
        }

        answer = Long.parseLong(str);
        return answer;
    }

    static long solution2(long n) {
        long answer = 0;
        StringBuilder s = new StringBuilder();
        Long.toString(n).chars().mapToObj(c -> (char) c).sorted(Collections.reverseOrder()).forEach(s::append);
        answer = Long.parseLong(s.toString());

        System.out.println("answer = " + answer);
        return answer;
    }
}
