package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem26 {
    static ArrayList<Integer>[] array;
    static boolean[] visited;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        array = new ArrayList[n+1];
        visited = new boolean[n+1];
        queue = new LinkedList<>();

        // 초기화
        for (int i = 1; i < n + 1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            array[a].add(b);
            array[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(array[i]);
        }

        visited[start] = true;
        DFS(start);
        System.out.println();

        visited = new boolean[n+1]; // 초기화
        BFS(start);

    }

    static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for (int i : array[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int node) {
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for (int i : array[now_node]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
