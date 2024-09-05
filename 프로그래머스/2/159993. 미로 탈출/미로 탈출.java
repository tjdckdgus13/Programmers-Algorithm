import java.util.*;
class Solution {
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int N, M;
    static int startX, startY;
    static String[][] map;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            String a = maps[i];
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(a.charAt(j));
                if (a.charAt(j) == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }
        
        return bfs();
    }
    
    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        boolean[][] visit = new boolean[N][M];
        visit[startY][startX] = true;

        int LX = 0;
        int LY = 0;
        int count = 0;
        boolean b = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (map[node.y][node.x].equals("L")) {
                LX = node.x;
                LY = node.y;
                count = node.count;
                b = true;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int moveX = node.x + X[i];
                int moveY = node.y + Y[i];

                if (check(visit, moveX, moveY)) continue;
                queue.add(new Node(moveX, moveY, node.count + 1));
                visit[moveY][moveX] = true;
            }
        }

        if (!b) return -1;
        
        queue.clear();
        queue.add(new Node(LX, LY, count));
        visit = new boolean[N][M];
        visit[LY][LX] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (map[node.y][node.x].equals("E")) {
                count = node.count;
                b = false;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int moveX = node.x + X[i];
                int moveY = node.y + Y[i];

                if (check(visit, moveX, moveY)) continue;

                queue.add(new Node(moveX, moveY, node.count + 1));
                visit[moveY][moveX] = true;
            }
        }
        
        return !b ? count : -1;
    }
    
    static boolean check(boolean[][] visit, int moveX, int moveY) {
        return moveX >= M || moveX < 0 || moveY >= N || moveY < 0 || visit[moveY][moveX] ||
            map[moveY][moveX].equals("X");
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}