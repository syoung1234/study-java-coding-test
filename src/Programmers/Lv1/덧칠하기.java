package Programmers.Lv1;

import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/161989
 */
public class 덧칠하기 {
    public static void main(String[] args) {
        int[] section = {2, 3, 6};
        solution(8, 4, section);
    }

    static int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] array = new boolean[n+1];

        for (int i : section) {
            array[i] = true;
        }

        int start = 1;

        while (section[section.length-1] >= start) {
            if (array[start]) { // 칠 해야함
                for (int i = start; i < start+m; i++) {
                    if (i > n) {
                        break;
                    }
                    array[i] = false;
                }
                start = start + m;
                answer++;
            } else {
                start++;
            }
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        System.out.println("answer = " + answer);
        return answer;
    }
}
