package Chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class problem28 {
    static ArrayList<Edge>[] array;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        array = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            while (true) {
                int node = Integer.parseInt(stringTokenizer.nextToken());
                if (node == -1) {
                    break;
                }
                int distance = Integer.parseInt(stringTokenizer.nextToken());
                array[num].add(new Edge(node, distance));
            }
        }
        visited[1] = true;
        BFS(1);
        int max = 1;
        for (int i = 2; i < n+1; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        // 초기화
        visited = new boolean[n+1];
        distance = new int[n+1];

        visited[max] = true;
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (Edge i : array[num]) {
                if(!visited[i.node]) {
                    visited[i.node] = true;
                    distance[i.node] = distance[num] + i.distance;
                    queue.add(i.node);
                }
            }
        }
    }
}

class Edge {
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

}