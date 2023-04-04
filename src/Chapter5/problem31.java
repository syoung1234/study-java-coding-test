package Chapter5;

import java.util.Scanner;

public class problem31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int start = 1;
        int end = k;
        while (start <= end) {
            int count = 0;
            int mid = (start + end) / 2;

            for (int i = 1; i < n+1; i++) {
                count = count + Math.min(mid/i, n);
            }

            if (count < k) {
                // 오른쪽만 보면 됨
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
