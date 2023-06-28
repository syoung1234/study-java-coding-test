package Programmers.Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * HaseSet 으로 푸는게 속도가 훨씬 빠름
 */
public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        solution(nums);
        solution2(nums);
    }

    static int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;
        int[] array = Arrays.stream(nums).distinct().toArray();

        if (array.length >= max) {
            answer = max;
        } else {
            answer = array.length;
        }

        System.out.println("answer1 = " + answer);
        return answer;
    }

    static int solution2(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        if (set.size() >= max) {
            answer = max;
        } else {
            answer = set.size();
        }

        System.out.println("answer2 = " + answer);
        return answer;
    }
}
