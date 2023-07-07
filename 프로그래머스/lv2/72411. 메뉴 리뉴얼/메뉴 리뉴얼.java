import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    static Map<String, Integer> map;
	static boolean[] bl;
	static int max;
    public String[] solution(String[] orders, int[] course) {

		for (int i = 0; i < orders.length; i++) {
			char[] a = orders[i].toCharArray();
			Arrays.sort(a);
			orders[i] = String.valueOf(a);
		}

		List<String> list = new ArrayList<>();

		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			max = Integer.MIN_VALUE;
			int count = course[i];
			for (int j = 0; j < orders.length; j++) {
				if (count > orders[j].length()) {
					continue;
				}

				String order = orders[j];
				bl = new boolean[order.length()];
				dfs(order, "", 0, 0, count);
			}

			for (String str : map.keySet()) {
				if (map.get(str) > 1 && map.get(str) == max) {
					list.add(str);
				}
			}
		}

		Collections.sort(list);
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
    
    static void dfs(String order, String str, int idx, int n, int count) {
		if (n == count) {
			map.put(str, map.getOrDefault(str, 0) + 1);
			max = Math.max(max, map.get(str));
			return;
		}

		for (int i = idx; i < order.length(); i++) {
			if (bl[i]) {
				continue;
			}

			bl[i] = true;
			dfs(order, str + order.charAt(i), i + 1, n + 1, count);
			bl[i] = false;
		}
	}
}