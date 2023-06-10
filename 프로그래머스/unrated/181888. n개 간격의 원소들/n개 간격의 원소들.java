class Solution {
    public int[] solution(int[] num_list, int n) {
       int[] answer;
		double a = num_list.length / (double) n;
		if (a != (int) (num_list.length / n)) {
			answer = new int[num_list.length / n + 1];
		} else {
			answer = new int[num_list.length / n];
		}

		for (int i = 0, j = 0; i < num_list.length; j++) {

			answer[j] = num_list[i];
			i += n;
			if (i > num_list.length) {
				break;
			}
		}
        return answer;
    }
}