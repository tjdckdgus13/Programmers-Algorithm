class Solution {
    public int[] solution(int[] arr) {
        	int min = Integer.MAX_VALUE;
		for (int i : arr) {
			if (min > i) {
				min = i;
			}
		}

		if (arr.length == 1) {
			int[] answer = { -1 };
            return answer;
		}

		int[] answer = new int[arr.length - 1];

		for (int i = 0, j = 0; i < arr.length; i++) {
			if (min == arr[i]) {
				continue;
			}
			answer[j] = arr[i];
			j++;
		}
        return answer;
    }
}