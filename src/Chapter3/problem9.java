package Chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem9 {
    static int[] checkArray = new int[4];
    static int[] minCountArr = new int[4]; // 0: A, 1: C, 2: G, 3: T
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 첫 번째 줄

        int s = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());
        char[] array = new char[s];

        array = bufferedReader.readLine().toCharArray();
        for (int i = 0; i < p; i++) { // default
            addPassword(array[i]);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 세 번째 줄
        for (int i = 0; i < 4; i++) { // 필수
            minCountArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start_index = 0;
        int end_index = p - 1;

        checkPassword();
        while (end_index < s - 1) {
            removePassword(array[start_index]); // start_index 빼기
            start_index++; // start_index 값 오른쪽으로 한 칸 이동
            end_index++; // end_index 값 오른쪽으로 한 칸 이동
            addPassword(array[end_index]);
            checkPassword();
        }
        System.out.println(result);
        bufferedReader.close();
    }

    private static void addPassword(char password) {
        switch (password) {
            case 'A':
                checkArray[0] += 1;
                break;
            case 'C':
                checkArray[1] += 1;
                break;
            case 'G':
                checkArray[2] += 1;
                break;
            case  'T':
                checkArray[3] += 1;
                break;
        }
    }

    private static void removePassword(char password) {
        switch (password) {
            case 'A':
                checkArray[0] -= 1;
                break;
            case 'C':
                checkArray[1] -= 1;
                break;
            case 'G':
                checkArray[2] -= 1;
                break;
            case  'T':
                checkArray[3] -= 1;
                break;
        }
    }

    private static void checkPassword() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (minCountArr[i] <= checkArray[i]) {
                count++;
            } else {
                break;
            }
        }
        if (count == 4) {
            result++;
        }
    }
}
