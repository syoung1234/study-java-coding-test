package Chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
    - 시간 초과
    - 따로 class를 빼서 할 필요 없었음
    - 배열에 담아서 depth 구하듯이 처리 가능
    - BFS로 푸는것이 조금 더 빠름
 ***/
public class problem47_fail {
    static ArrayList<Integer>[] arrayList;
    static int[] depthArray;
    static int depth;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer= new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken()); // 노드 개수
        int m = Integer.parseInt(stringTokenizer.nextToken()); // 에지 개수
        arrayList = new ArrayList[n+1];
        NodeDepth[] nodeDepth = new NodeDepth[n+1];
        depthArray = new int[n+1];

        // 초기화
        for (int i = 0; i < n+1; i++) {
            arrayList[i] = new ArrayList<>();
            nodeDepth[i] = new NodeDepth(i, 0);
        }

        for (int i = 1; i < n; i++) {
            stringTokenizer= new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayList[b].add(a);
        }


        // 탐색 시작
        depth = 0;
        DFS(1);
        nodeDepth[1].node = 1;
        nodeDepth[1].depth = depth;


        for (int i = 1; i < n; i++) {
            if (!arrayList[i].isEmpty()) {
                depth = 0;
                DFS(i+1);
                nodeDepth[i+1].node = i+1;
                nodeDepth[i+1].depth = depth;
            }
        }

        // 정렬
        Arrays.sort(nodeDepth, new Comparator<NodeDepth>() {
            @Override
            public int compare(NodeDepth o1, NodeDepth o2) {
                return Integer.compare(o2.depth, o1.depth);
            }
        });

        System.out.print(nodeDepth[0].node + " ");
        // max 값 찾기, 1개 이상일 수 있음
        for (int i = 0; i < n+1; i++) {
            if (nodeDepth[i].depth == nodeDepth[i+1].depth) {
                System.out.print(nodeDepth[i+1].node + " ");
            } else {
                break;
            }
        }
    }

    static void DFS(int node) {
        for (int i : arrayList[node]) {
            depth++;
            DFS(i);
        }
    }

    static class NodeDepth {
        private int node;
        private int depth;

        NodeDepth(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }

    }

}
