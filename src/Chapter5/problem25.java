package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class problem25 {
    static boolean[] visited;
    static ArrayList<Integer>[] array;
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        array = new ArrayList[n];
        visited = new boolean[n];

        // 초기화 필수
        for (int i = 0; i < n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            array[a].add(b);
            array[b].add(a);
        }


        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(i, 1);
                if (result) {
                    break;
                }
            }
        }

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void DFS(int num, int depth) {
        if (depth == 5) {
            result = true;
            return;
        }
        visited[num] = true;
        for (int i : array[num]) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[num] = false;
    }
}
