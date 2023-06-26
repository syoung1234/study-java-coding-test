package Programmers.Lv1;

import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
public class 나머지가_1이_되는_수찾기 {
    public static void main(String[] args) {
        System.out.println("solution(12) = " + solution(12));
    }

    static int solution(int n) {
        return IntStream.range(1, n).filter(i -> n % i == 1).findFirst().getAsInt();
    }
}
