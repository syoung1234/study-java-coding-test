package Chapter3;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int l = Integer.parseInt(stringTokenizer.nextToken()); // 검사할 개수
        int[] result = new int[n];
        Deque<Node> deque = new LinkedList<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());

            while (!deque.isEmpty() && deque.getLast().value >= num) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, num));

            if (deque.getFirst().index < i - l + 1) {
                deque.removeFirst();
            }

            result[i] = deque.getFirst().value;
            bufferedWriter.write(deque.getFirst().value + " ");
            // System.out.print(deque.getFirst().value + " ");
        }

        // System.out.println(Arrays.toString(result));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }
}
