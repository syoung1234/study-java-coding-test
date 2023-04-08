package Chapter7;

import java.util.Scanner;

public class problem37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean[] array = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            array[i] = true;
        }

        array[0] = array[1] = false;

        for (int i = 2; i < n+1; i++) { // 16의 경우 4*4, 4의 배수까지만 해도 됨
            if (array[i]) {
                for (int j = i*i; j < n+1; j += i) {
                    array[j] = false;
                }
            }
        }

        for (int i = m; i < n+1; i++) {
            if (array[i]) {
                System.out.println(i);
            }
        }

    }
}
