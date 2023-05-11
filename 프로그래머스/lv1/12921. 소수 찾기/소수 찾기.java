class Solution {
    public int solution(int n) {
        boolean[] bl = new boolean[n + 1];
		bl[0] = bl[1] = true;
		for (int i = 2; i <= n; i++) {
			if (bl[i])
				continue;
			for (int j = 2 * i; j <= n; j += i) {
				bl[j] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i < bl.length; i++) {
			if (!bl[i]) {
				answer++;
			}
		}
        return answer;
    }
}