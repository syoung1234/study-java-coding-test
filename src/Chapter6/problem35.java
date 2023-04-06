package Chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];

        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }

        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int now = 0;

        for (int i = 0; i < n; i++) {
            if (now <= array[i][0]) { // 현재 회의 끝나는 시간 <= 다음 회의 시작 시간
                now = array[i][1];
                count++;
            }
        }
        System.out.println(count);
    }

}
