import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> mapX = new HashMap<String, Integer>();
		Map<String, Integer> mapY = new HashMap<String, Integer>();

		for (String i : X.split("")) {
			if (mapX.containsKey(i)) {
				mapX.put(i, mapX.get(i) + 1);
				continue;
			}

			mapX.put(i, 1);
		}

		for (String i : Y.split("")) {
			if (mapY.containsKey(i)) {
				mapY.put(i, mapY.get(i) + 1);
				continue;
			}

			mapY.put(i, 1);
		}

		List<String> list = new ArrayList<String>();

		for (String i : mapX.keySet()) {
			if (!mapY.containsKey(i)) {
				continue;
			}

			int num = Math.min(mapX.get(i), mapY.get(i));
			for (int j = 0; j < num; j++) {
				list.add(i);
			}
		}

		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		for (String i : list) {
			sb.append(i);
		}

		String answer = "";
		if (list.size() == 0) {
			answer = "-1";
		} else if (list.get(0).equals("0")) {
			answer = "0";
		} else {
			answer = sb.toString();
		}
        return answer;
    }
}