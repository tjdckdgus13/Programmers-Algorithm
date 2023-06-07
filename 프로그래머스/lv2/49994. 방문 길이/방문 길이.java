import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(String dirs) {
       	Map<Character, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();

		map.put('U', 1);
		map.put('D', -1);
		map.put('L', -1);
		map.put('R', 1);

		int[][] check = new int[6][6];
		int x = 0, y = 0;
		int answer = 0;
		for (int i = 0; i < dirs.length(); i++) {
			char ch = dirs.charAt(i);

			if (ch == 'U' || ch == 'D') {
				int Y = y + map.get(ch);
				String str1 = x + " " + y + " " + x + " " + Y;
				String str2 = x + " " + Y + " " + x + " " + y;
				if (y + map.get(ch) < -5 || y + map.get(ch) > 5) {
					continue;
				} else if (set.contains(x + " " + y + " " + x + " " + Y)) {
					y = Y;
					continue;
				}
				set.add(str1);
                set.add(str2);
				y = Y;
				answer++;
			} else {

				int X = x + map.get(ch);
				String str1 = x + " " + y + " " + X + " " + y;
				String str2 = X + " " + y + " " + x + " " + y;
				if (x + map.get(ch) < -5 || x + map.get(ch) > 5) {
					continue;
				} else if (set.contains(str1) || set.contains(str2)) {
					x = X;
					continue;
				}
				set.add(str1);
				set.add(str2);
				x = X;
				answer++;
			}
		}

        return answer;
    }
}