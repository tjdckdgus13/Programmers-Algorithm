import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

		int[] answer = new int[score.length];
		for (int i = 0; i < score.length; i++) {
			arr.add(score[i]);
			Collections.sort(arr, (o1, o2) -> Integer.compare(o2, o1));
			if (arr.size() < k + 1) {
				answer[i] = arr.get(arr.size() - 1);
				continue;
			}
			answer[i] = arr.get(k - 1);
		}
        return answer;
    }
}