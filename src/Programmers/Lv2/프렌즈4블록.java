package Programmers.Lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
 */
public class 프렌즈4블록 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        solution(m, n, board);
    }

    static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] block = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                block[i][j] = board[i].charAt(j);
            }
        }

        boolean remove = true;
        // 내가 가는 방향 ->
        while (remove) {
            boolean[][] check = new boolean[m][n];
            remove = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char current = block[i][j];
                    if (current == '0') continue;
                    // 나와 오른쪽 옆, 아래, 대각선 아래가 같다면 2x2 완성
                    if (current == block[i+1][j] && current == block[i][j+1] && current == block[i+1][j+1]) {
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        remove = true;
                    }
                }
            }


            // 2x2 블록 삭제
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) { // 삭제
                        answer++;
                        // 나머지 아래로 떨어뜨리기
                        // 반복 처리 필요 한 개만 옮길 수 없음
                        int change = i;
                        while (change > 0) {
                            block[change][j] = block[change-1][j];
                            block[change-1][j] = '0';
                            change--;
                        }
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
