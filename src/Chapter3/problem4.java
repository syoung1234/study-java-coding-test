package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 첫 번쨰 줄

        int n = Integer.parseInt(stringTokenizer.nextToken()); // 표의 크기 n * n
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 합을 구해야 하는 횟수

        int[][] array = new int[n+1][n+1];
        int[][] sumArray = new int[n+1][n+1];

        // 배열 정의
        for (int i = 1; i < n+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 두 번째 ~ N+1 번째줄
            for (int j = 1; j < n+1; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                sumArray[i][j] = sumArray[i-1][j] + sumArray[i][j-1] - sumArray[i-1][j-1] + array[i][j];
             }
        }

        // 정답 도출
        for (int q = 0; q < m; q++) {
            int result = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // N+2 번째줄 ~ N+M+1 번째 줄
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            result = sumArray[x2][y2] - sumArray[x1-1][y2] - sumArray[x2][y1-1] + sumArray[x1-1][y1-1];

            System.out.println(result);
        }

    }
}
