import java.util.HashMap;
import java.util.Map;
class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		int num = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (num == 11) {
					num++;
					continue;
				}
				map.put(num++, new int[] { i, j });
			}
		}

		map.put(0, new int[] { 3, 1 });
		int left = 10;
		int right = 12;
		String answer = "";
		for (int i : numbers) {
			if (i == 1 || i == 4 || i == 7) {
				left = i;
				answer += "L";
				continue;
			} else if (i == 3 || i == 6 || i == 9) {
				right = i;
				answer += "R";
				continue;
			}
			int[] n = map.get(i);
			int[] l = map.get(left);
			int[] r = map.get(right);

			int lmove = Math.abs(l[0] - n[0]) + Math.abs(l[1] - n[1]);
			int rmove = Math.abs(r[0] - n[0]) + Math.abs(r[1] - n[1]);

			if (lmove > rmove) {
				right = i;
				answer += "R";
			} else if (lmove < rmove) {
				left = i;
				answer += "L";
			} else {
				if (hand.equals("left")) {
					left = i;
					answer += "L";
				} else {
					right = i;
					answer += "R";
				}
			}
		}
        return answer;
    }
}