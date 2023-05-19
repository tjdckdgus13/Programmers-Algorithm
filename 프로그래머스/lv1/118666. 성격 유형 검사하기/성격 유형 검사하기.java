import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("R", 0);
		map.put("T", 0);
		map.put("C", 0);
		map.put("F", 0);
		map.put("J", 0);
		map.put("M", 0);
		map.put("A", 0);
		map.put("N", 0);

		for (int i = 0; i < survey.length; i++) {
			String left = survey[i].substring(0, 1);
			String right = survey[i].substring(1);
			int a = 0;
			int b = 0;
			switch (choices[i]) {
			case 1:
				a = 3;
				break;
			case 2:
				a = 2;
				break;
			case 3:
				a = 1;
				break;
			case 5:
				b = 1;
				break;
			case 6:
				b = 2;
				break;
			case 7:
				b = 3;
				break;
			}

			map.put(left, map.get(left) + a);
			map.put(right, map.get(right) + b);
		}

		String[] all = { "RT", "CF", "JM", "AN" };
		String answer = "";
		for (int i = 0; i < all.length; i++) {
			String left = all[i].substring(0, 1);
			String right = all[i].substring(1);

			if (map.get(left) > map.get(right) || map.get(left) == map.get(right)) {
				answer += left;
			} else {
				answer += right;
			}
		}
        return answer;
    }
}