package Programmers.Lv2;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 순서 중요!
 */
public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};
        solution(order);
    }

    static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int length = order.length;
        int[] container = new int[length];

        Arrays.setAll(container, (i) -> i+1);

        int j = 0;
        boolean check = false;
        for (int i = 0; i < length; i++) {
            // 보조 먼저 확인
            if (!sub.isEmpty()) {
                if (order[i] == sub.peek()) {
                    answer++;
                    sub.pop();
                } else {
                    check = false;
                }
                if (check) continue;
            }

            while (j != length) {
                if (order[i] == container[j]) {
                    answer++;
                    j++;
                    check = true;
                    break;
                } else {
                    check = false;
                    sub.push(container[j]);
                }
                j++;
            }

            if (!check) {
                break;
            }
        }


        System.out.println("answer = " + answer);
        return answer;
    }

}
