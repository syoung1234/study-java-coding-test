package Chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class problem48 {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static boolean result;
    static int[] setArray;
    static int edge;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int n = Integer.parseInt(bufferedReader.readLine());
        int count = 0;


        while (n > count) {
            String[] s = bufferedReader.readLine().split(" ");
            int node = Integer.parseInt(s[0]);
            edge = Integer.parseInt(s[1]);

            arrayList = new ArrayList[node+1];
            visited = new boolean[node+1];
            setArray = new int[node+1];
            result = true;

            // 초기화
            for (int i = 0; i < node+1; i++) {
                arrayList[i] = new ArrayList<>();
            }

            for (int i = 0; i < edge; i++) {
                s = bufferedReader.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                arrayList[a].add(b);
                arrayList[b].add(a);
            }

            for (int i = 1; i < node+1; i ++) {
                visited[i] = true;
                result = true;
                DFS(i);
                if (!result) {
                    break;
                }
            }


            if (!result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

            count++;
        }

    }

    static void DFS(int node) {
        visited[node] = true;
        for (int i : arrayList[node]) {
            if (!visited[i]) {
                setArray[i] = (setArray[node] + 1) % 2; // 이 부분 중요
                DFS(i);
            } else if (setArray[i] == setArray[node]) {
                result = false;
            }
        }
    }
}
