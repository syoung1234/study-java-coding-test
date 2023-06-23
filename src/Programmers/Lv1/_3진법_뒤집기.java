package Programmers.Lv1;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class _3진법_뒤집기 {
    public static void main(String[] args) {
        solution(125);
    }

    static int solution(int n) {
        int answer = 0;
        // 10진수 -> 3진수
        String str = Integer.toString(n, 3);

        // 뒤집기
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        str = stringBuilder.toString();

        // 3진수 -> 10진수
        answer = Integer.parseInt(str, 3);

        System.out.println("answer = " + answer);
        return answer;
    }
}
