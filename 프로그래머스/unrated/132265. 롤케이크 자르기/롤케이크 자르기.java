import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(int[] topping) {
        Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : topping) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int answer = 0;
		for (int i : topping) {
			map.put(i, map.get(i) - 1);
			set.add(i);
			if (map.get(i) == 0)
				map.remove(i);
			if (set.size() == map.size())
				answer++;
		}
        return answer;
    }
}