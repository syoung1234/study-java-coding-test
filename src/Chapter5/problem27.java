package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem27 {
    static int[][] array;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int n, m;

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        // n * m
        for (int i = 1; i < n+1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String line = stringTokenizer.nextToken();
            for (int j = 1; j < m+1; j++) {
                array[i][j] = Integer.parseInt(line.substring(j-1,j));
            }
        }

        BFS(1, 1);
        for (int i = 1; i < n+1; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        System.out.println(array[n][m]);

    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i,j });
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            // 주변 찾기
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x > 0 && y > 0 && x <= n && y <= m) { // 유효성
                    if (array[x][y] != 0 && !visited[x][y]) {
                        // 이동할 수 있음
                        queue.add(new int[] { x, y});
                        array[x][y] = array[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
