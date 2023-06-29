package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class 연속된_부분_수열의_합 {
    public static void main(String[] args) {
        int[] sequence = {1,2,3,4,5};
        int k = 7;
        solution(sequence, k);
    }

    static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum = sequence[0];
        int i = 0;
        int j = 0;
        int min = 1000000;

        while (i < sequence.length && j < sequence.length) {
            if (sum == k) {
                if (j-i < min) {
                    answer[0] = i;
                    answer[1] = j;
                    min = j - i;
                }
                sum -= sequence[i];
                i++;
            } else if (sum < k) {
                j++;
                if (j < sequence.length) {
                    sum += sequence[j];
                }
            } else { // sum 이 더 큰 경우
                sum -= sequence[i];
                i++;
            }

        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}
