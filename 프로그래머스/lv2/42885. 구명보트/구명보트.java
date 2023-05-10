import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

		int answer = 0;
		int a = 0;
		for (int i = people.length - 1; a <= i;) {
			if (people[i] + people[a] <= limit) {
				a++;
			}
			i--;
			answer++;
		}
        return answer;
    }
}