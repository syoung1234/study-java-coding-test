package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 방문_길이 {
    public static void main(String[] args) {
        solution("ULURRDLLU");
    }

    static int[][][][] arr = new int[11][11][11][11];
    static int a = 5;
    static int b = 5;
    static Queue<Map<Integer,Integer>> queue = new LinkedList<>();
    static int solution(String dirs) {
        int answer = 0;
        int[][] way = {{0,-1}, {0,1}, {-1,0}, {-1,-1}, {-1,1}, {1,0}, {1,-1}, {1,1}};
        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'L') {
                answer += moveL();
            } else if (dirs.charAt(i) == 'R') {
                answer += moveR();
            } else if (dirs.charAt(i) == 'U') {
                answer += moveU();
            } else {
                answer += moveD();
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    static int moveL() {
        if (b-1 >= 0) {
            return check(a, b, a, --b);
        }
        return 0;
    }

    static int moveR() {
        if (b+1 <= 10) {
            return check(a, b, a, ++b);
        }
        return 0;
    }

    static int moveU() {
        if (a-1 >= 0) {
            return check(a, b, --a, b);
        }
        return 0;
    }

    static int moveD() {
        if (a+1 <= 10) {
            return check(a, b, ++a, b);
        }
        return 0;
    }

    static int check(int i, int j, int k, int q) {

        if (arr[i][j][k][q] > 0) {
            return 0;
        } else {
            arr[i][j][k][q] = 1;
            arr[k][q][i][j] = 1;
            return 1;
        }
    }


}
