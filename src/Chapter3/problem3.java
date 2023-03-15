package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException { // BufferedReader 사용할 때는 IOException 필수
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken()); // 데이터 개수
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 합을 구해야하는 횟수

        int[] a = new int[n];
        long[] s = new long[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        a[0] = Integer.parseInt(stringTokenizer.nextToken());
        s[0] = a[0];
        for (int x = 1; x < n; x++) {
            a[x] = Integer.parseInt(stringTokenizer.nextToken()); // 입력한 각각의 값 배열에 담기
            s[x] = s[x-1] + a[x]; // 누적 합
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(s));

        for (int y = 0; y < m; y++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // i ~ j
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            if (i-2 < 0) {
                System.out.println(s[j-1]);
            } else {
                System.out.println(s[j-1] - s[i-2]);
            }

        }

    }
}
