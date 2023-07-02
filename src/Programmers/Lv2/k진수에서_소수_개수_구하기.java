package Programmers.Lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class k진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
        // solution(437674, 3);
        // solution(110011, 10);
        solution(100000, 2);
    }

    static int solution(int n, int k) {
        int answer = 0;
        // k진수로 변환
        String str = Integer.toString(n, k);
        System.out.println("str = " + str);
        String[] array = str.split("0");

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) continue;

            long num = Long.parseLong(array[i]);
            boolean prime = isPrime(num);

            if (prime) {
                answer++;
            }
        }

        System.out.println(answer);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        return answer;
    }

    private static boolean isPrime(long num) {
        boolean check = true;
        if (num > 2) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    check = false;
                    break;
                }
            }
        } else if (num == 1) {
            check = false;
        }

        return check;
    }
}
