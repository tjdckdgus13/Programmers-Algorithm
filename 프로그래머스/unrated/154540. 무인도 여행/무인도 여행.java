import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    static int[] X = { 1, 0, -1, 0 };
	static int[] Y = { 0, 1, 0, -1 };
	static int[][] map;
    public int[] solution(String[] maps) {
        
        boolean b = false;
        
        map = new int[maps.length][maps[0].length()];
        
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length(); j++) {
				if (maps[i].charAt(j) == 'X') {
					map[i][j] = -1;
				} else {
                    b = true;
					map[i][j] = maps[i].charAt(j) - '0';
				}
			}
		}
        
        if (!b) return new int[] {-1};
            
		List<Integer> list = new ArrayList<>();
        
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length(); j++) {
				if (map[i][j] == -1) {
					continue;
				} else {
					list.add(bfs(i, j));
				}
			}
		}

		int[] answer = new int[list.size()];
        
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);
        return answer;
    }
    
    public static int bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();

		int result = map[y][x];
        
		map[y][x] = -1;

		q.add(new int[] { y, x });

		while (!q.isEmpty()) {
			int[] a = q.poll();

			for (int i = 0; i < 4; i++) {
				int xmove = X[i] + a[1];
				int ymove = Y[i] + a[0];
				if (xmove > map[0].length - 1 || xmove < 0 || ymove > map.length - 1 || ymove < 0) {
					continue;
				}

				if (map[ymove][xmove] == -1) {
					continue;
				}
				q.add(new int[] { ymove, xmove });
				result += map[ymove][xmove];
				map[ymove][xmove] = -1;
			}
		}
		return result;
	}
}