import java.util.*;
class Solution {
    static String[][] map;
    static int x, y, startX, startY;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static boolean[][] check;

    public int solution(String[] board) {
        x = board[0].length();
        y = board.length;

        check = new boolean[y][x];
        map = new String[y][x];

        for (int i = 0; i < y; i++) {
            String[] s = board[i].split("");
            for (int j = 0; j < x; j++) {
                if (s[j].equals("R")) {
                    startX = j;
                    startY = i;
                }

                map[i][j] = s[j];
            }
        }
        return bfs();
    }
    
    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        check[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (map[node[1]][node[0]].equals("G")) {
                return node[2];
            }

            for (int i = 0; i < 4; i++) {
                int moveX = node[0];
                int moveY = node[1];

                while (true) {
                    if (checkB(moveX, moveY)) {
                        break;
                    }
                    moveX += X[i];
                    moveY += Y[i];
                }

                moveX -= X[i];
                moveY -= Y[i];

                if (check[moveY][moveX] || (moveX == node[0] && moveY == node[1])) continue;


                queue.add(new int[]{moveX, moveY, node[2] + 1});
                check[moveY][moveX] = true;
            }
        }

        return -1;
    }
    
    static boolean checkB(int moveX, int moveY) {
        return moveX < 0 || moveX >= x || moveY < 0 || moveY >= y || map[moveY][moveX].equals("D");
    }

}