import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(int n, int t, int m, int p) {
        Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(11, "B");
		map.put(12, "C");
		map.put(13, "D");
		map.put(14, "E");
		map.put(15, "F");

		StringBuilder sb = new StringBuilder("0");
		for (int i = 1; i < t * m; i++) {
			int num = i;
			String str = "";
			while (num > 0) {
				int check = num % n;
				if (map.containsKey(check)) {
					str = map.get(check) + str;
					num /= n;
					continue;
				}
				str = (num % n) + str;
				num /= n;
			}
			sb.append(str);
		}

		StringBuilder answer = new StringBuilder();
		for (int i = p - 1; i < sb.length(); i = i + m) {
			if (answer.length() >= t) {
                return answer.toString();
            }
			answer.append(sb.charAt(i));
		}
        return answer.toString();
    }
}