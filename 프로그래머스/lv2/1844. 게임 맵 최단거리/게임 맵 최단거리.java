import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, -1, 0, 1 };
    public int solution(int[][] maps) {
        
		int[][] visit = new int[maps.length][maps[0].length];

		bfs(maps, visit);

		return visit[maps.length - 1][maps[0].length - 1] > 0 ? visit[maps.length - 1][maps[0].length - 1] : -1;
    }
    
    public static void bfs(int[][] maps, int[][] visit) {
		Queue<int[]> q = new LinkedList<int[]>();
		int x = 0;
		int y = 0;
		visit[x][y] = 1;

		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int ax = q.peek()[0];
			int ay = q.peek()[1];
			q.poll();

			for (int i = 0; i < 4; i++) {
				int bx = X[i] + ax;
				int by = Y[i] + ay;

				if (bx < 0 || bx > maps.length - 1 || by < 0 || by > maps[0].length - 1) {
					continue;
				}

				if (maps[bx][by] == 1 && visit[bx][by] == 0) {
					visit[bx][by] = visit[ax][ay] + 1;
					q.add(new int[] { bx, by });
				}
			}
		}
	}
}