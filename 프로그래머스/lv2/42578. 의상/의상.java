import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			String a = clothes[i][1];
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		int answer = 1;
		for (String i : map.keySet()) {
			int a = map.get(i);
			answer *= a + 1;
		}
        return answer - 1;
    }
}