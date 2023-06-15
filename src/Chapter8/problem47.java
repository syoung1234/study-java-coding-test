package Chapter8;

import java.io.*;
import java.util.*;

public class problem47 {
    static int[] countArray;
    static ArrayList<Integer>[] arrayList;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken()); // 노드 개수
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 에지 개수
        arrayList = new ArrayList[n+1];
        countArray = new int[n+1];

        // 초기화
        for (int i = 0; i < n+1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayList[a].add(b);
        }


        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            BFS(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, countArray[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (max == countArray[i]) {
                bufferedWriter.write(i + " ");
            }
        }

        // System.out.println("countArray = " + Arrays.toString(countArray));
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i : arrayList[nowNode]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    countArray[i]++;
                }
            }
        }
    }
}
