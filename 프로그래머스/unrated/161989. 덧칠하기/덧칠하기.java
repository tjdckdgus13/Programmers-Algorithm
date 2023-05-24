class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0] + m - 1;
		int answer = 1;
		for (int i = 1; i < section.length; i++) {
			if (start < section[i]) {
				start = section[i] + m - 1;
				answer++;
			}
		}
        return answer;
    }
}