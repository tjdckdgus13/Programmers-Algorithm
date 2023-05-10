import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, -1, 0, 1 };
	static int[][] visit = new int[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
       	visitCheck(rectangle);
		int answer = bfs(rectangle, characterX * 2, characterY * 2, itemX * 2, itemY * 2);

		return answer;
    }
    
    public static void visitCheck(int[][] rectangle) {
		for (int[] a : rectangle) {
			for (int i = 0; i < 4; i++) {
				a[i] *= 2;
			}

			for (int i = a[0]; i <= a[2]; i++) {
				for (int j = a[1]; j <= a[3]; j++) {
					visit[i][j] = 1;
				}
			}
		}

		for (int[] a : rectangle) {
			for (int i = a[0] + 1; i < a[2]; i++) {
				for (int j = a[1] + 1; j < a[3]; j++) {
					visit[i][j] = 0;
				}
			}
		}
	}
    
    public static int bfs(int[][] rectangle, int cX, int cY, int iX, int iY) {
		Queue<int[]> q = new LinkedList<int[]>();
		visit[cX][cY] = 0;
		q.add(new int[] { cX, cY, 0 });

		int count = Integer.MAX_VALUE;
		while (!q.isEmpty()) {

			int[] a = q.poll();

			if (a[0] == iX && a[1] == iY && count > a[2]) {
				count = a[2];
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int mX = a[0] + X[i];
				int mY = a[1] + Y[i];

				if (mX >= 2 && mX < visit.length && mY >= 2 && mY < visit.length) {
					if (visit[mX][mY] == 1) {
						q.add(new int[] { mX, mY, a[2] + 1 });
						visit[mX][mY] = 0;
					}
				}
			}

		}

		return count / 2;
	}
}