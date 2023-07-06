package Programmers.Lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12928
 */
public class 약수의_합 {
    public static void main(String[] args) {
        solution(12);
    }

    static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer+= i;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
