import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> mapW = new HashMap<String, Integer>();
		for (int i = 0; i < want.length; i++) {
			mapW.put(want[i], number[i]);
		}

		int discountL = discount.length;
		int answer = 0;
		for (int i = 0; i <= discountL - 10; i++) {
			Map<String, Integer> mapD = new HashMap<String, Integer>();
			for (int j = 0; j < 10; j++) {
				String a = discount[i + j];
				mapD.put(a, mapD.getOrDefault(a, 0) + 1);
			}
			if (check(mapW, mapD)) {
				answer++;
			}
		}
        return answer;
    }
    
    public static boolean check(Map<String, Integer> mapW, Map<String, Integer> mapD) {
		for (String i : mapW.keySet()) {
			if (!mapD.containsKey(i) || mapW.get(i) != mapD.get(i)) {
				return false;
			}
		}
		return true;
	}
}