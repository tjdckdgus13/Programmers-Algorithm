import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < targets.length; i++) {
			int count = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				String ch = targets[i].substring(j, j + 1);
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < keymap.length; k++) {
					if (keymap[k].contains(ch)) {
						min = Math.min(min, keymap[k].indexOf(ch) + 1);
					}
				}
                if (min == Integer.MAX_VALUE) {
				    count = -1;
				    break;
				}
				count += min;
			}
			list.add(count);
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}