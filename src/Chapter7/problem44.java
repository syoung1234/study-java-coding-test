package Chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 매우 어려움
public class problem44 {
    static boolean[] visited;
    static ArrayList<cNode>[] arrayList;
    static long[] dist;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arrayList = new ArrayList[n];
        visited = new boolean[n];
        long num = 0;
        long lcm = 1;
        dist = new long[n];

        // arrayList 초기화
        for (int i = 0; i < n; i++) {
            arrayList[i] = new ArrayList<cNode>();
        }

        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            arrayList[a].add(new cNode(b, p, q));
            arrayList[b].add(new cNode(a, q, p));
            num = gcd(p,q); // 최대공약수
            lcm *= p * q / num; // 최소공배수
        }
        dist[0] = lcm;
        DFS(0);

        long mgcd = dist[0];
        // 최소가 되어야함
        for (int i = 0; i < n; i++) {
            mgcd = gcd(mgcd, dist[i]);
        }

        // System.out.println(mgcd);

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] / mgcd + " ");
        }
        // System.out.println(Arrays.toString(dist));
    }

    static void DFS(int node) {
        visited[node] = true;
        for (cNode i : arrayList[node]) {
            int next = i.b;
            if (!visited[next]) {
                dist[next] = dist[node] * i.q / i.p;
                DFS(next);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static class cNode {
        int b;
        int p;
        int q;
        cNode(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }
}
