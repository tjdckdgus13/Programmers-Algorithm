import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int oneG = 0;
		int twoG = 0;
		int threeG = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == one[i % 5])
				oneG++;
			if (answers[i] == two[i % 8])
				twoG++;
			if (answers[i] == three[i % 10])
				threeG++;
		}

		int a = Math.max(oneG, Math.max(twoG, threeG));

		if (oneG == a)
			arr.add(1);
		if (twoG == a)
			arr.add(2);
		if (threeG == a)
			arr.add(3);

		int[] answer = new int[arr.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
        return answer;
    }
}