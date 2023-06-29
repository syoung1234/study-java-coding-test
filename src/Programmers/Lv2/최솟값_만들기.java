package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class 최솟값_만들기 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        solution(a, b);
    }

    static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int length = A.length;

        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length-1-i];
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
