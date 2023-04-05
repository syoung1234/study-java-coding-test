package Chapter6;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(); // 오름차순
        int one = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            if (m > 1) { // 양수
                positiveQueue.add(m);
            } else if (m == 1) {
                one++;
            } else if (m < 0) {
                negativeQueue.add(m);
            } else if (m == 0) {
                zero++;
            }
        }

        int result = 0;
        // 양수
        while (positiveQueue.size() > 1) {
            int a = positiveQueue.poll();
            int b = positiveQueue.poll();
            result += a * b;
        }
        if (!positiveQueue.isEmpty()) {
            result += positiveQueue.poll();
        }

        // 음수
        while (negativeQueue.size() > 1) {
            int a = negativeQueue.poll();
            int b = negativeQueue.poll();
            result += a * b;
        }
        if (!negativeQueue.isEmpty()) {
            if (zero > 0) {
                negativeQueue.poll();
            } else {
                result += negativeQueue.poll();
            }
        }

        // 1 더하기
        result += one;

        System.out.println(result);
    }
}
