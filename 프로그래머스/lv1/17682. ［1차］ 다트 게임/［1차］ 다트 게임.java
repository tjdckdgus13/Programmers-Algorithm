import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(String dartResult) {
      Queue<Character> q = new LinkedList<Character>();

        int re = dartResult.length();
		for (int i = 0; i < re; i++) {
			q.add(dartResult.charAt(i));
		}
        
		int check = 0;
		int[] arr = new int[3];
		int answer = 0;
		while (!q.isEmpty()) {
			char c = q.poll();
			int num;
			if (q.peek() == '0') {
				num = Character.getNumericValue(c + q.poll());
			} else {
				num = Character.getNumericValue(c);
			}

			int count = 0;
			while (q.peek() > '9' || q.peek() < '0') {
				char a = q.poll();
				switch (a) {
				case 'S':
					count = num;
					break;
				case 'D':
					count = num * num;
					break;
				case 'T':
					count = num * num * num;
					break;
				case '*':
					if (check == 0) {
						count *= 2;
					} else {
						count *= 2;
						arr[check - 1] = arr[check - 1] * 2;
					}
					break;
				case '#':
					count *= -1;
					break;
				}
				if (q.peek() == null)
					break;
			}
			arr[check] = count;
			check++;
		}
		for (int i : arr) {
			answer += i;
		}
        return answer;
    }
}