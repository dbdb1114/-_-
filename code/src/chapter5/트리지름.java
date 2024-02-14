package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 지름은 트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 것을 말한다.
 * 트리의 지름을 구하시오.
 *
 * 1번째 줄에서는 트리의 노드 개수 V(2 <= V <= 100,000),
 * 2번째 줄부터 V개의 줄에 걸쳐 에지의 정보가 주어진다.
 * 먼저 노드 번호가 주어지고, 그 다음으로 연결된 에지의 정보를 의미하는 정수가 2개씩 주어진다.
 * 거리는 10,000 이하의 자연수다.
 *
 * 예제 입력1
 * 5
 * 1 3 2 -1
 * 2 4 4 -1
 * 3 1 2 4 3 -1
 * 4 2 4 3 3 5 6 -1
 * 5 4 6 -1
 *
 * 예제 출력
 * 11
 * */
public class 트리지름 {
    static class Node{
        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        int node;
        int distance;

    }

    static boolean[] visited;
    static int[] distanceArr;
    static ArrayList<Node>[] nodeArrayList;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int nodeQuantity = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[nodeQuantity+1];
        distanceArr = new int[nodeQuantity+1];

        nodeArrayList = new ArrayList[nodeQuantity+1];
        nodeArrayList[0] = new ArrayList<>();

        for (int i = 1; i < nodeQuantity+1; i++) {

            String[] line = bufferedReader.readLine().split(" ");
            int nodeNum = Integer.parseInt(line[0]);
            nodeArrayList[nodeNum] = new ArrayList<>();

            for (int j = 1; j < line.length - 1; j+=2) {

                int node = Integer.parseInt(line[j]);
                int distance = Integer.parseInt(line[j+1]);

                nodeArrayList[nodeNum].add(new Node(node, distance));
            }
        }

        BFS(1);

        int start = 0;
        for (int i = 0; i < distanceArr.length; i++) {
            if(distanceArr[i] > distanceArr[start]){
                start = i;
            }
        }

        distanceArr = new int[nodeQuantity+1];
        visited = new boolean[nodeQuantity+1];
        BFS(start);

        System.out.println(Arrays.stream(distanceArr).max().getAsInt());
    }

    static void BFS(int start){

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Node now_node = queue.poll();
            nodeArrayList[now_node.node].stream().forEach(next_node -> {
                if(!visited[next_node.node]){
                    visited[next_node.node] = true;
                    distanceArr[next_node.node] += next_node.distance + distanceArr[now_node.node];
                    queue.offer(next_node);
                }
            });
        }

    }
}
