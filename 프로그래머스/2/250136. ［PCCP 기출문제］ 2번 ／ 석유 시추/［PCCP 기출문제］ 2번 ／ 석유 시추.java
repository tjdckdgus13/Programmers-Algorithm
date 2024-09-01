import java.util.*;
class Solution {
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static boolean[][] visit;
    static int N, M;
    static int[] map;
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        visit = new boolean[N][M];
        map = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j] || land[i][j] == 0) continue;

                bfs(land, j, i);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : map) {
            max = Math.max(max, i);
        }
        
        int answer = max;
        return answer;
    }
    
     static void bfs(int[][] land, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(new Node(x, y));
        set.add(x);
         
        visit[y][x] = true;
        
        int count = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = node.x + X[i];
                int moveY = node.y + Y[i];

                if (check(land, moveX, moveY)) continue;

                set.add(moveX);
                visit[moveY][moveX] = true;
                queue.add(new Node(moveX, moveY));
                count++;
            }
        }

        for (int i : set) {
            map[i] += count;
        }
    }
    
    static boolean check(int[][] land, int x, int y) {
        return x >= M || x < 0 || y >= N || y < 0 || land[y][x] == 0 || visit[y][x];
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}