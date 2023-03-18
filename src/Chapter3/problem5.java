package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 매우 어려웠음
public class problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = new int[n];
        int[] sumArray = new int[n];
        int[] mArray = new int[n];
        int[] countArray = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        array[0] = Integer.parseInt(stringTokenizer.nextToken());
        sumArray[0] = array[0];
        mArray[0] = sumArray[0] % m;

        int result = 0;

        for (int i = 1; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken()); // 원본 배열
            sumArray[i] = sumArray[i-1] + array[i]; // 합 배열
            mArray[i] = sumArray[i] % 3; // 나머지 값 배열
        }

        // 0부터의 합 배열
        for (int i = 0; i < n; i++) {
            int remainder = mArray[i] % 3;
            if (remainder == 0) {
                result++;
            }
            countArray[remainder]++;
        }

        // 0을 제외한 합 배열
        for (int i = 0; i < m; i++) {
            if (countArray[i] > 1) {
                // 2가지를 뽑는 경우 n(n-1)/2
                result = result + (countArray[i] * (countArray[i] -1) / 2);
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sumArray));
        System.out.println(Arrays.toString(mArray));
        System.out.println(Arrays.toString(countArray));
        System.out.println(result);
    }
}
