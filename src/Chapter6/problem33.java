package Chapter6;

import java.util.PriorityQueue;
import java.util.Scanner;

public class problem33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        int sum = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();

            sum = sum + a + b;
            // queue 에 다시 더해줘야함
            queue.add(a+b);
        }

        System.out.println(sum);
    }
}
