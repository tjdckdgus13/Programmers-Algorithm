import java.util.Arrays;
class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);

		int[] count = new int[tangerine[tangerine.length - 1] + 1];
		for (int i = 0; i < tangerine.length; i++) {
			count[tangerine[i]]++;
		}

		Arrays.sort(count);

		long v = 0;
		int answer = 0;
		for (int i = count.length - 1; i > 0; i--) {

			if (k > v + count[i]) {
				v += count[i];
				answer++;
				
			} else {
				answer++;
				break;
			}
		}
        return answer;
    }
}