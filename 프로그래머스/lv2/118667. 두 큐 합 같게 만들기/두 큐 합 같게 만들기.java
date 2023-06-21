import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> dque1 = new ArrayDeque<>();
		Deque<Integer> dque2 = new ArrayDeque<>();

		dque1 = insert(queue1);
		dque2 = insert(queue2);

		long sum1 = dque1.pollLast();
		long sum2 = dque2.pollLast();

        if ((sum1 + sum2) % 2 != 0) return -1;
        
		int answer = 0;
		while (true) {
			if (answer > (queue1.length + queue2.length) * 2) 
			    return -1;
			
			if (sum1 == sum2) {
				return answer;
			} else if (sum1 > sum2) {
				int a = dque1.pollFirst();
				sum1 -= a;
				sum2 += a;
				dque2.addLast(a);
				answer++;
			} else {
				int a = dque2.pollFirst();
				sum1 += a;
				sum2 -= a;
				dque1.addLast(a);
				answer++;
			}
		}
    }
    
    public static Deque<Integer> insert(int[] queue) {
        
		Deque<Integer> dque = new ArrayDeque<>();
        
		int sum = 0;
        
		for (int i : queue) {
			dque.add(i);
			sum += i;
		}
        
		dque.add(sum);
		return dque;
	}
}