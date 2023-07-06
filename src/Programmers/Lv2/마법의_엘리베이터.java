package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * DFS
 */
public class 마법의_엘리베이터 {
    public static void main(String[] args) {
        // solution(55700);
        solution2(646);
    }

    static int min = Integer.MAX_VALUE;
    static int solution(int storey) {
        int answer = 0;
        String str = "0" + storey;
        int length = str.length()-1;
        int num, preNum;
        boolean add = false;
        for (int i = length; i > 0; i--) {
            num = Integer.parseInt(str.substring(i-1, i));
            if (add) {
                num++;
            }
            if (num < 5) {
                answer += num;
                add = false;
            } else if (num > 5) {
                answer += 10 - num;
                add = true;

                if (i == 1) {
                    answer += 1;
                }
            } else {
                preNum = Integer.parseInt(str.substring(i-2, i-1));
                if (preNum < 5) {
                    answer += num;
                    add = false;
                } else {
                    answer += 10 - num;
                    add = true;
                }
            }
        }

        if (add) {
            answer++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    static int solution2(int storey) {
        int answer = 0;
        DFS(storey, 0);
        System.out.println("min = " + min);
        return answer;
    }

    static void DFS(int storey, int sum) {
        System.out.println("min = " + min);
        System.out.println("storey = " + storey);
        if (sum > min) return;
        if (storey == 0) {
            min = sum;
            return;
        }

        int remainder = storey % 10;
        storey = storey / 10;

        DFS(storey, sum + remainder);
        DFS(storey + 1, sum + 10 - remainder);
    }
}
