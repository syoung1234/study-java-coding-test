package Programmers.Lv1;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 */
public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        solution(24, 27);
    }

    static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            int count = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    count++;
                    int num = i / j;
                    if (num == j) {
                        break;
                    } else if (num * j == i) {
                        count++;
                    }
                }
            }

            if (count % 2 == 0) { // 짝수
                answer += i;
            } else { // 홀수
                answer -= i;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
