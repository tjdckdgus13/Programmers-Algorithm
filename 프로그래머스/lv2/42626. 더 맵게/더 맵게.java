import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
       PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i : scoville) {
			queue.add(i);
		}

		int answer = 0;
		while (queue.size() >= 2) {
			if (queue.peek() >= K)
				break;

			int a = queue.poll() + (queue.poll() * 2);
			queue.add(a);
			answer++;
		}
        if (queue.peek() < K) return -1;
        return answer;
    }
}