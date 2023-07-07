package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        solution(prices);
    }
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int second;
        for (int i = 0; i < prices.length; i++) {
            second = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    second = j - i;
                    break;
                } else {
                    second = j - i;
                }
            }
            answer[i] = second;
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}
