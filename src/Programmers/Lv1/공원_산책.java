package Programmers.Lv1;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class 공원_산책 {
    public static void main(String[] args) {
        String[] park = {"OSO","OOO", "OXO", "OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        solution(park, routes);
    }

    static int x;
    static int y;
    static int lenX;
    static int lenY;
    static int[][] intPark;

    static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 직사각형
        lenX = park.length;
        lenY = park[0].length();
        intPark = new int[lenX][lenY];

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                char ch = park[i].charAt(j);
                if (ch == 'O') {
                    intPark[i][j] = 0;
                } else if (ch == 'X') {
                    intPark[i][j] = 1;
                } else {
                    // start
                    x = i;
                    y = j;
                }
            }
        }


        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");
            int move = Integer.parseInt(s[1]);
            int tempX = x;
            int tempY = y;
            Move m = new Move();
            boolean result = false;
            for (int j = 0; j < move; j++) {

                if (s[0].equals("E")) {
                    result = m.east(tempY);
                    tempY++;
                } else if (s[0].equals("W")) {
                    result = m.west(tempY);
                    tempY--;
                } else if (s[0].equals("S")) {
                    result = m.south(tempX);
                    tempX++;
                } else {
                    result = m.north(tempX);
                    tempX--;
                }

                if (!result) {
                    break;
                }
            }

            if (result) {
                x = tempX;
                y = tempY;
            }

        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    static class Move {

        boolean east(int y) {
            y = y + 1;
            if (y < lenY) {
                return this.validation(x, y);
            }
            return false;
        }

        boolean west(int y) {
            y = y - 1;
            if (y >= 0) {
                return this.validation(x, y);
            }
            return false;
        }

        boolean south(int x) {
            x = x + 1;
            if (x < lenX) {
                return this.validation(x, y);
            }
            return false;
        }

        boolean north(int x) {
            x = x - 1;
            if (x >= 0) {
                return this.validation(x, y);
            }
            return false;
        }

        boolean validation(int x, int y) {
            return intPark[x][y] == 0;
        }
    }
}
