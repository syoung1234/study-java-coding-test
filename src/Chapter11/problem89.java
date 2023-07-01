package Chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속된 정수의 합 구하기
 * 백준 13398번
 */
public class problem89 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        int[] array = new int [n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 배열 초기화
        for (int i = 1; i < n+1; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        left[1] = array[1];
        right[n] = array[n];

        if (n == 1) {
            System.out.println(array[1]);
            return;
        }

        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;

        // left
        for (int i = 2; i < n+1; i++) {
            left[i] = Math.max(array[i], left[i-1] + array[i]);
            maxL = Math.max(maxL, left[i]);
        }

        // right
        for (int i = n-1; i > 0; i--) {
            right[i] = Math.max(array[i], right[i+1] + array[i]);
            maxR = Math.max(maxR, right[i]);
        }

        int max = Math.max(maxL, maxR);
        int temp = 0;
        // 1개씩 빼보기
        for (int i = 1; i < n; i++) {
            temp = left[i-1] + right[i+1];
            max = Math.max(max, temp);
        }

        System.out.println("result = " + max);
    }
}
