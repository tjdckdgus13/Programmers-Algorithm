import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();
		for (int i = 0; i < cards1.length; i++) {
			q1.add(cards1[i]);
		}

		for (int i = 0; i < cards2.length; i++) {
			q2.add(cards2[i]);
		}

		String answer = "Yes";
		for (int i = 0; i < goal.length; i++) {
			String card1 = q1.isEmpty() ? "" : q1.peek();
			String card2 = q2.isEmpty() ? "" : q2.peek();
			if (card1.equals(goal[i])) {
				q1.poll();
				continue;
			} else if (card2.equals(goal[i])) {
				q2.poll();
				continue;
			}
			answer = "No";
			break;
		}
        return answer;
    }
}