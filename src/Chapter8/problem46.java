package Chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem46 {
    static ArrayList<Integer>[] array;
    static int[] visited;
    static Queue<Integer> queue;
    static int k;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // BFS
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()); // 도시의 개수
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 도로의 개수
        k = Integer.parseInt(stringTokenizer.nextToken()); // 거리 정보
        int x = Integer.parseInt(stringTokenizer.nextToken()); // 출발 도시 번호

        array = new ArrayList[n+1];
        visited = new int[n+1];
        queue = new LinkedList<>();

        // 배열 초기화
        for (int i = 0; i < n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            array[a].add(b);
        }

        BFS(x);

        for (int i = 0; i < n+1; i++) {
            if (visited[i] == k+1) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int i : answer) {
                System.out.println(i);
            }
        }

    }

    static void BFS(int node) {
        queue.add(node);
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int newNode = queue.poll();

            for (int i : array[newNode]) {
                if (visited[i] == 0) {
                    queue.add(i);
                    visited[i] = visited[newNode] + 1;
                }
            }
        }
    }
}
