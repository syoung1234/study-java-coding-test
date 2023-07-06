package Programmers.Lv1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class 자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        solution(12354);
    }

    static int[] solution(long n) {
        int[] answer = {};

        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        answer = new int[chars.length];
        int j = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            answer[j] = Integer.parseInt(String.valueOf(chars[i]));
            j++;
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));


        return answer;
    }

    // 시간은 훨씬 더 오래 걸림
    static int[] solution2(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
