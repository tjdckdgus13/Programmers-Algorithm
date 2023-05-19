import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] score = { 0, 5, 4, 3, 2, 1 };
		int[] lottos2 = Arrays.copyOf(lottos, lottos.length);
		int up = up(lottos, win_nums);
		int down = down(lottos2, win_nums);
		int[] answer = { up <= 1 ? 6 : score[up - 1], down <= 1 ? 6 : score[down - 1] };
        return answer;
    }
    
    public static int up(int[] lottos, int[] win_nums) {
		int a = 0;
		for (int i = 0; i < win_nums.length; i++) {
			for (int j = 0; j < lottos.length; j++) {
				if (lottos[j] == -1) {
					continue;
				} else if (lottos[j] == 0) {
					lottos[j] = -1;
					a++;
					continue;
				} else if (win_nums[i] == lottos[j]) {
					lottos[j] = -1;
					a++;
					continue;
				}
			}
		}
		return a;
	}
    
    public static int down(int[] lottos, int[] win_nums) {
		int a = 0;

		for (int i = 0; i < win_nums.length; i++) {
			for (int j = 0; j < lottos.length; j++) {
				if (lottos[j] == 0 || lottos[j] == -1) {
					continue;
				} else if (win_nums[i] == lottos[j]) {
					lottos[j] = -1;
					a++;
					continue;
				}
			}
		}
		return a;
	}
}