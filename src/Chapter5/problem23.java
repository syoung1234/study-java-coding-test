package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem23 {
    static boolean[] visited;
    static ArrayList<Integer>[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        array = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            array[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            array[a].add(b);
            array[b].add(a);
        }

        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void DFS(int v) {

        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i : array[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
