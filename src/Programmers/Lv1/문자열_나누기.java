package Programmers.Lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108
 */
public class 문자열_나누기 {
    public static void main(String[] args) {
        solution("banana");
    }

    static int solution(String s) {
        int answer = 0;
        int same = 0;
        int different = 0;

        char start = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == start) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                answer++;
                same = 0;
                different = 0;
                if (i + 1 < s.length()) {
                    start = s.charAt(i+1);
                }
            }
        }

        if (same != different) {
            answer++;
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
