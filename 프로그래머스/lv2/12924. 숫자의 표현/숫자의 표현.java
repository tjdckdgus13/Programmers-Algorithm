class Solution {
    public int solution(int n) {
        int count = 0;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			count = 0;
			for (int j = i; j <= n; j++) {
				count += j;

				if (count == n) {
					answer++;
				} else if (count > n) {
					break;
				}

			}
		}
        return answer;
    }
}