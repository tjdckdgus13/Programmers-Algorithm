import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2];

		for (int i = 0; i < stages.length; i++) {
			arr[stages[i]]++;
		}

		int a = stages.length;

		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 0) {
				map.put(i, 0.0);
				continue;
			}
			double b = (double) arr[i] / a;
			map.put(i, b);
			a -= arr[i];

		}

		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}