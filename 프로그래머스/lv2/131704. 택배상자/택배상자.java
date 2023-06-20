import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= order.length; i++) {
			q.add(i);
		}

		boolean b = true;
		int answer = 0;
		for (int i = 0; i < order.length; i++) {
			int a = order[i];
			while (true) {
				if (q.isEmpty() && s.peek() != a) {
					b = false;
					break;
				}
				if (!q.isEmpty() && q.peek() == a) {
					q.poll();
					answer++;
					break;
				} else if (!s.isEmpty() && s.peek() == a) {
					s.pop();
					answer++;
					break;
				}
				s.add(q.poll());
			}
			if (!b)
				break;
		}
        return answer;
    }
}