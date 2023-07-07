import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();

		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			if (stack.isEmpty() || prices[i] >= stack.peek()[1]) {
				stack.add(new int[] { i, prices[i] });
				continue;
			}

			while (!stack.isEmpty() && prices[i] < stack.peek()[1]) {
				int[] s = stack.pop();
				answer[s[0]] = i - s[0];
			}
			stack.add(new int[] { i, prices[i] });
		}

		if (!stack.isEmpty()) {
			int n = prices.length - 1;
			while (true) {
				if (stack.isEmpty()) {
					break;
				}
				int[] a = stack.pop();
				answer[a[0]] = n - a[0];
			}
		}
        return answer;
    }
}