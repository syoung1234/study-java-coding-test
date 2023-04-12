package Chapter7;

import java.util.Scanner;

public class problem40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        boolean[] array = new boolean[(int) (max-min+1)];
        int count = 0;

        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start_index = min / square;  // 안해주면 시간 초과남!
            if (min%square != 0)
                start_index++;
            for (long j = start_index; square * j <= max; j++) {
                if (square*j >= min) {
                    array[(int) (square * j - min)] = true;
                }
            }
        }

        for (int i = 0; i <= max-min; i++) {
            if (!array[i]) {
                count++;
            }
        }


        System.out.println(count);
    }
}
