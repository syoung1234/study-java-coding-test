package Chapter3;

import java.io.*;
import java.util.PriorityQueue;

public class problem14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int x = Math.abs(o1);
            int y = Math.abs(o2);

            if (x == y) {
                return o1 > o2 ? 1 : -1;
            } else {
                return x - y;
            }
        });

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            if (num == 0) {
                if (priorityQueue.isEmpty()) {
                    bufferedWriter.write('0' + "\n");
                } else {
                    bufferedWriter.write(priorityQueue.poll() + "\n");
                }

            } else {
                priorityQueue.add(num);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
