package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        int count = 0;


        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array); // 정렬

        int start_index = 0;
        int end_index = n-1;
        while (start_index < end_index) {
            int sum = 0;
            sum = array[start_index] + array[end_index];

            if (sum > m) {
                end_index--;
            } else if (sum < m) {
                start_index++;
            } else {
                count++;
                start_index++;
                end_index--;
            }
        }

        System.out.println(count);
    }
}
