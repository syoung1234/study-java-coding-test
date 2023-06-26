package Programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class 체육복 {
    static Map<Integer, Integer> map = new  HashMap<>();
    static int count = 0;
    public static void main(String[] args) {
        int[] lost = {2,3,5};
        int[] reserve = {3,4,6};
        solution(6,lost, reserve);
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            map.put(reserve[i], 1); // 빌려줄 수 있음
        }

        for (int i = 0; i < lost.length; i++) {
            Check check1 = new Check(lost[i]);
            int lend = check1.lend();
            if (lend == 1) {
                continue;
            } else if (lend == 0) { // 뺏어야함
                count--;
                count++;
                continue;
            }

            Check check2 = new Check(lost[i]-1);
            if (check2.lend() == 1) {
                continue;
            }

            Check check3 = new Check(lost[i]+1);
            if (check3.lend() == 1) {
                continue;
            }
        }
        answer = answer + count;

        System.out.println("answer = " + answer);
        return answer;
    }

    static class Check {
        private int index;

        Check(int index) {
            this.index = index;
        }

        private int lend() {
            Integer lend = map.getOrDefault(index, -1);
            if (lend == 1) {
                map.put(index, 0);
                count++;
            }
            return lend;
        }
    }
}
