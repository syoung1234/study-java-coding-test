package Programmers.Lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 */
public class 소수_찾기 {
    public static void main(String[] args) {
        solution(5);
    }

    static int solution(int n) {
        int answer = 0;
        int[] array = new int[n+1];

        // 2 <= n <= 1,000,000, 1은 소수 아님
        for (int i = 0; i < n+1; i++) {
            array[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (array[i] != 0) {
                for (int j = i+i; j < n+1; j += i) {
                    array[j] = 0;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            if (array[i] != 0) {
                answer++;
            }
        }

        System.out.println("count = " + answer);
        return answer;
    }
}
