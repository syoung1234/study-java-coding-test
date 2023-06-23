package Programmers.Lv1;

import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        solution(numbers);
    }

    static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (index == numbers.length) {
                answer += i;
            } else if (numbers[index] == i) {
                index++;
            } else {
                answer += i;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }
}
