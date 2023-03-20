package Chapter3;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] array = new int[n];
        int[] resultArr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
                resultArr[stack.peek()] = array[i];
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            resultArr[num] = -1;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(resultArr[i] + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
