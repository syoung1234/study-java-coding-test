package Chapter7;

import java.util.Scanner;

public class problem39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[10000001]; // n보다 충분히 큰 수를 담아야 함

        // 1 <= n <= 1,000,000
        // '에라토스테네스의 체'를 이용하여 소수 구하기
        for (int i = 2; i < 10000001; i++) {
            array[i] = i;
        }

        for (int i = 0; i <= Math.sqrt(10000000); i++) {
            if (array[i] != 0) { // 소수
                // 배수 지우기
                for (int j = i+i; j < 10000001; j += i) {
                    array[j] = 0;
                }
            }
        }

        for (int i = 0; i < 10000001; i++) {
            if (array[i] >= n) {
                // 팰린드롬 수
                if (palindrome(array[i])) {
                    System.out.println(array[i]);
                    break;
                }

            }
        }
    }

    static boolean palindrome(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int start = 0;
        int end = arr.length-1;
        boolean result = true;

        while (start <= end) {
            if (arr[start] != arr[end]) {
                result = false;
                break;
            } else {
                start++;
                end--;
            }
        }

        return result;
    }
}
