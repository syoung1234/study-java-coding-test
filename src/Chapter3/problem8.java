package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(array);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int fineNum = array[i];
            int start_index = 0;
            int end_index = n - 1;

            while (start_index < end_index) {
                int sum = array[start_index] + array[end_index];
                if (fineNum > sum) {
                    start_index++;
                } else if (fineNum < sum) {
                    end_index--;
                } else {
                    if (start_index != i && end_index != i) {
                        count++;
                        break;
                    }
                }

            }
        }

        System.out.println(count);


    }
}
