package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=java
 */
public class 제일_작은_수_제거하기 {
    public static void main(String args[]) {
        int[] array = {1,3,4};
        solution(array);
    }

    static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        int index = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (i == minIndex) index = 1;
            answer[i] = arr[i+index];
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}
