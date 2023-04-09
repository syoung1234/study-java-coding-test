package Chapter7;

import java.util.Scanner;

public class problem38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long[] array = new long[10000001];
        int count = 0;

        for (int i = 2; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (array[i] != 0) {
                for (int j = i+i; j < array.length; j += i) {
                    array[j] = 0;
                }

            }
        }


        // n(i) <= B ----> n <= B/n(i-1)
        for (int i = 2; i < array.length; i++) {
            if (array[i] != 0) {
                long n = array[i];
                while ((double)array[i] <= (double)b/(double)n) {
                    if ((double)array[i] >= (double)a/(double)n) {
                        count++;
                    }
                    n = n * array[i];
                }
            }
        }




        System.out.println(count);
    }
}
