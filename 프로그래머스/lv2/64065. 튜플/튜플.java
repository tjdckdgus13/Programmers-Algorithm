import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("[^0-9]", " ").split("\\s+");

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String i : arr) {
			if (i.equals(""))
				continue;

			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
		});

		int[] answer = new int[list.size()];

		int a = 0;
		for (Map.Entry<String, Integer> i : list) {
			answer[a] = Integer.parseInt(i.getKey());
			a++;
		}
        return answer;
    }
}