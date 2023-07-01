import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public int[] solution(String msg) {
      
        Map<String, Integer> map = new HashMap<>();
		for (int i = 1, j = 0; i <= 26; i++, j++) {
			map.put(String.valueOf((char) ('A' + j)), i);
		}
      
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < msg.length(); i++) {
			int num = 0;
			int n = i + 1;

			String str = String.valueOf(msg.charAt(i));
			while (true) {
				String a = str;

				if (map.containsKey(a)) {
					if (n == msg.length()) {
						num = map.get(a);
						break;
					}
					num = map.get(a);
					str += msg.charAt(n);
					n++;
					i++;
				} else {
					i--;
					break;
				}
			}
			list.add(num);
			map.put(str, map.size() + 1);
		}
      
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

    return answer;  
  }
}