package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem29 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] nArray = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] mArray = new int[m];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Arrays.sort(nArray);
        for (int k = 0; k < m; k++) {
            mArray[k] = Integer.parseInt(stringTokenizer.nextToken());
            int start = 0;
            int end = n - 1;

            while (start <= end) {
                int mid = (start+end)/2;
                if (mArray[k] == nArray[mid]) {
                    System.out.println(1);
                    break;
                } else if (mArray[k] > nArray[mid]) {
                    // 오른쪽만 탐색
                    start = mid + 1;
                } else {
                    // 왼쪽만 탐색
                    end = mid - 1;
                }

                if (start > end || end < 0) {
                    System.out.println(0);
                }
            }
        }
    }
}
