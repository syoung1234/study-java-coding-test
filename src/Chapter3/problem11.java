package Chapter3;

import java.util.Scanner;
import java.util.Stack;

public class problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        int n = scanner.nextInt();
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();

        }

        boolean result = true;
        for (int i = 0; i < n; i++) {
            if (array[i] >= num) { // push
                while (array[i] >= num) {
                    stack.push(num++);
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            } else { // pop or NO
                int pop = stack.pop();
                if (pop > array[i]) {
                    result = false;
                    System.out.println("NO");
                    break;
                }
                stringBuffer.append("-\n");
            }
        }

        if (result) {
            System.out.println(stringBuffer);
        }

    }
}
