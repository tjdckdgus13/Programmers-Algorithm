import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
		for (int i : arr) {
			arrL.add(i);
		}

		for (int i = 0; i < query.length; i++) {
			if (i % 2 == 0) {
				while (arrL.size() != query[i] + 1) {
					arrL.remove(query[i] + 1);
				}
			} else {
				for (int j = 0; j < query[i]; j++) {
					arrL.remove(0);
				}
			}
		}

		int answer[] = new int[arrL.size()];
		for (int i = 0; i < arrL.size(); i++) {
			answer[i] = arrL.get(i);
		}

        return answer;
    }
}