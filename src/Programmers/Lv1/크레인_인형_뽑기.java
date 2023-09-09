package Programmers.Lv1;

import java.util.Stack;

public class 크레인_인형_뽑기 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        solution(board, moves);
    }

    static Stack<Integer> stack = new Stack<>();
    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board[0].length;

        for (int m : moves) {
            m = m-1;
            for (int x = 0; x < len; x++) {
                if (board[x][m] > 0) {
                    if (!checkBucket(board[x][m])) {
                        stack.push(board[x][m]);
                    } else {
                        answer += 2;
                    }

                    board[x][m] = 0;
                    break;
                }
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }

    static boolean checkBucket(int currentNum) {
        if (stack.isEmpty()) {
            return false;
        }
        boolean result = false;
        int preNum = stack.peek();
        if (preNum == currentNum) {
            result = true;
            stack.pop();
        }

        return result;
    }
}
