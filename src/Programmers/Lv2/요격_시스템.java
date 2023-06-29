package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class 요격_시스템 {
    public static void main(String[] args) {
//        int[][] targets = {
//                {4,5}, {4,8}, {10,14}, {11,13},
//                {5,12}, {3,7}, {1,4}
//        };
        int[][] targets = {
                {0,4}, {5,10}, {6,8}, {8,9}
        };
        solution(targets);
    }

    static int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        int max = 0;
        for (int[] i : targets) {
            System.out.println("i = " + Arrays.toString(i));

            if (i[0] >= max) {
                // 겹치지 않음
                max = i[1];
                answer++;
            } else {
                if (max > i[1]) {
                    max = i[1];
                }
            }

        }
        System.out.println("count = " + answer);
        return answer;
    }

}
