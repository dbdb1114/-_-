package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

public class 미로탈출 {

    static int[][] Arr;
    static boolean[][] visited;

    static int N;
    static int M;
    // 상하좌우
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                Arr[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});

        BFS(queue);

        System.out.println(Arr[N-1][M-1]);
    }

    static BiPredicate<Integer, Integer> upCheck = (x,y)  -> y > 0 && !visited[y-1][x] && Arr[y-1][x] == 1;
    static BiPredicate<Integer, Integer> downCheck = (x,y) -> y < N-1 && !visited[y+1][x] && Arr[y+1][x] == 1;
    static BiPredicate<Integer, Integer> leftCheck = (x,y) -> x > 0 && !visited[y][x-1] && Arr[y][x-1] == 1;
    static BiPredicate<Integer, Integer> rightCheck = (x,y) -> x < M-1 && !visited[y][x+1] && Arr[y][x+1] == 1;

    public static void BFS(Queue<int[]> queue) {


        while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            visited[pos[0]][pos[1]] = true;


            for (int i = 0; i < 4; i++){

                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];

                if(x >= 0 && y>= 0 && x < N && y < M){
                    if(Arr[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        Arr[x][y] = Arr[pos[0]][pos[1]] + 1;
                        queue.add(new int[] {x,y});
                    }
                }
            }

        }

    }

}
