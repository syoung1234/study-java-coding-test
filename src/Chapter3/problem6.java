package Chapter3;

import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;
        int sum_count = 0;

        while (end_index <= n) {
            if (sum < n) {
                end_index++;
                sum = sum + end_index;
            } else if (sum > n) {
                sum = sum - start_index;
                start_index++;
            } else if (sum == n) {
                count++;
                end_index++;
                sum = sum + end_index;
            }
            sum_count++;
        }

        System.out.println(sum_count);
        System.out.println(count);
    }
}
