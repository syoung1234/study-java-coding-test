package Programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class 롤케이크_자르기 {
    public static void main(String[] args) {
        int[] topping = {1,2,1,3,1,4,1,2};
        solution(topping);
    }

    static int solution(int[] topping) {
        int answer = 0;

        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();

        int length = topping.length;
        int[] rightCount = new int[length];
        for (int i = length-1; i >= 0; i--) {
            right.add(topping[i]);
            rightCount[i] = right.size();
        }

        for (int i = 0; i < topping.length-1; i++) {
            left.add(topping[i]);

            if (left.size() == rightCount[i+1]) {
                answer++;
            }
        }


        System.out.println("answer = " + answer);
        return answer;
    }
}
