package basic.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DFS {
    static boolean[] visited;
    static ArrayList<Integer>[] arrayList;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        arrayList = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 0; i < m; i++) {
            Collections.sort(arrayList[i]);
        }

        dfs(k);

        System.out.println("result = " + result);

    }

    static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        result.add(node);
        for (int i : arrayList[node]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
