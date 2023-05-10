import java.util.ArrayList;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i < sum / 2; i++) {
			if (sum % i == 0) {
				arr.add(i);
			}
		}
		boolean bl = true;

		int[] answer = { 0, 0 };
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(i) > arr.get(j) && (sum == (arr.get(i) * arr.get(j)))) {
					if ((arr.get(i) - 2) * (arr.get(j) - 2) != yellow)
						continue;
					
					answer[0] = arr.get(i);
					answer[1] = arr.get(j);
					bl = false;
					break;
				}
			}
			if (!bl) {
				break;
			}
		}

		if (answer[0] == 0) {
			answer[0] = (int) Math.sqrt(sum);
			answer[1] = (int) Math.sqrt(sum);
		}
        return answer;
    }
}