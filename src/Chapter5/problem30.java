package Chapter5;

import java.util.Scanner;

public class problem30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        int end = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            end += array[i];
            if (start < array[i]) {
                start = array[i];
            }
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            System.out.println("start: " + start);
            System.out.println("end: " + end);
            System.out.println("mid: " + mid);
            for (int i = 0; i < n; i++) {
                if (sum + array[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += array[i];
            }
            if (sum != 0) {
                count++;
            }
            if (count > m) {
                start = mid+1;
            } else {
                end = mid-1;
            }
            System.out.println("count: " + count);
        }

        System.out.println(start);
    }
}
