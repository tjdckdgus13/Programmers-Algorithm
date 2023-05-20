class Solution {
    public String solution(int[] food) {
        String one = "";
		String two = "";
		for (int i = 1; i < food.length; i++) {
			int count = food[i] / 2;
			for (int j = 0; j < count; j++) {
				one = one + i;
				two = i + two;
			}
		}
        String answer = one + "0" + two;
        return answer;
    }
}