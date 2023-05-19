import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> hs = new HashSet<String>();

		for (int i = 0; i < report.length; i++) {
			hs.add(report[i]);
		}
        
		Iterator<String> iter = hs.iterator();

		Map<String, Integer> map = new HashMap<String, Integer>();
        
		for (String i : id_list) {
			map.put(i, 0);
		}

		while (iter.hasNext()) {
			String a = iter.next();
			int idx = a.indexOf(" ");
			a = a.substring(idx + 1);

			map.put(a, map.get(a) + 1);
		}
        
		iter = hs.iterator();
        
		Map<String, Integer> map1 = new HashMap<String, Integer>();

		for (String i : id_list) {
			map1.put(i, 0);
		}

		while (iter.hasNext()) {
			String b = iter.next();
			String[] arr = b.split(" ");

			if (map.get(arr[1]) >= k) {
				map1.put(arr[0], map1.get(arr[0]) + 1);
			}
		}

		int[] answer = new int[id_list.length];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = map1.get(id_list[i]);
		}
        
        return answer;
    }
}