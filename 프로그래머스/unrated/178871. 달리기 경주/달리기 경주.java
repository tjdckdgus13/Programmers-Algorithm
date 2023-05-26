import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
     Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}

		for (int i = 0; i < callings.length; i++) {

			int idx = map.get(callings[i]);

			String a = players[idx - 1];
			players[idx] = a;
			players[idx - 1] = callings[i];

			map.put(a, idx);
			map.put(callings[i], idx - 1);

		}
        String[] answer = players.clone();
        return answer;
    }
}