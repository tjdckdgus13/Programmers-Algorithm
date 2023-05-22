class Solution {
    public int solution(int number, int limit, int power) {
       int answer = 0;
		for (int i = 1; i <= number; i++) {
			int num = 1;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					num++;
				}
				if (num > limit) {
					num = power;
					break;
				}
			}

			answer += num;
		}
        return answer;
    }
}