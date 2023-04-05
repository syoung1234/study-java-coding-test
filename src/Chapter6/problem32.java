package Chapter6;

import java.util.Scanner;

public class problem32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int amount = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (amount >= array[i]) {
                count += amount / array[i];
                amount = amount % array[i];
            }

        }

        System.out.println(count);
    }
}
