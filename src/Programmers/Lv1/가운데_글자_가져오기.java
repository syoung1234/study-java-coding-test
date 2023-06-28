package Programmers.Lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12903
 */
public class 가운데_글자_가져오기 {
    public static void main(String[] args) {
        solution("a");
    }

    static String solution(String s) {
        String answer = "";
        int num = s.length() / 2;

        if (s.length() % 2 == 0) { // 짝수
            answer += s.charAt(num-1);
        }

        answer += s.charAt(num);

        System.out.println("answer = " + answer);
        return answer;
    }
}
