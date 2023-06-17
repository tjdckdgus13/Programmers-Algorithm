import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

		int answer = 0;
		for (int i = 0; i < citations.length; i++) {
			int a = citations.length - i;

			if (citations[i] >= a) {
				answer = a;
				break;
			}
		}
        return answer;
    }
}