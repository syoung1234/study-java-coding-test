package Programmers.Lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 * DP
 */
public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        solution(land);
    }

    static int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        int num;
        int len = land.length;
        int[] temp = new int[4];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    num = land[i-1][j] + land[i][k];
                    temp[k] = Math.max(temp[k], num);
                }
            }
            for (int t = 0; t < temp.length; t++) {
                land[i][t] = temp[t];
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(land[len-1][i], answer);
        }
        System.out.println("answer = " + answer);
        return answer;
    }
    /**
     * 시간 초과
     */
    static int max = Integer.MIN_VALUE;
    static int solution2(int[][] land) {
        int answer = 0;
        DFS(land,0, 0, 1, -1);
        System.out.println("max = " + max);

        return answer;
    }

    static void DFS(int[][] land, int sum, int i, int depth, int noNext) {
        System.out.println("i = " + i);
        if (i == land.length) {
            max = Math.max(sum, max);
            return;
        }

        for (int k = 0; k < land[0].length; k++) {
            if (k != noNext) { // 이전에 선택한 열이 아니라면
                DFS(land, sum + land[i][k], i + 1, depth + 1, k);
            }
        }
    }
}
