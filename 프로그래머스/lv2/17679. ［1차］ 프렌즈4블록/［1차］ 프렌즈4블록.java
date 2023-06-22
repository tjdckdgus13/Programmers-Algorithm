import java.util.ArrayList;
import java.util.List;
class Solution {
    static boolean[][] broken;
	static int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
		for (int i = 0; i < board.length; i++) {
			map[i] = board[i].toCharArray();
		}

		while (true) {
			int a = check(n, m, map);
			if (a == 0)
				break;
			map = change(n, m, map);
			map = drop(n, m, map);
		}
        return answer;
    }
    
    public static int check(int n, int m, char[][] map) {
		broken = new boolean[m][n];
		int a = 0;
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				char c = map[i][j];
				if (c == '0')
					continue;
				if (c == map[i][j + 1] && c == map[i + 1][j] && c == map[i + 1][j + 1]) {
					broken[i][j] = true;
					broken[i][j + 1] = true;
					broken[i + 1][j] = true;
					broken[i + 1][j + 1] = true;
					a++;
				}
			}
		}
		return a;
	}
    
    public static char[][] change(int n, int m, char[][] map) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (broken[i][j]) {
					map[i][j] = '0';
					answer++;
				}
			}
		}
		return map;
	}
    
    public static char[][] drop(int n, int m, char[][] map) {
		for (int i = 0; i < n; i++) {
			List<Character> list = new ArrayList<>();
			for (int j = m - 1; 0 <= j; j--) {
				if (map[j][i] != '0') {
					list.add(map[j][i]);
					map[j][i] = '0';
				}
			}
			for (int k = 0, f = m - 1; k < list.size(); k++, f--) {
				map[f][i] = list.get(k);
			}
		}
		return map;
	}
}