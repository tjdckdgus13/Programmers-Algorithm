import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Info> queue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			if (i == location) {
				queue.add(new Info(priorities[i], true));
			}
			queue.add(new Info(priorities[i], false));
		}

		int answer = 0;

		while (!queue.isEmpty()) {
			Info info = queue.poll();
			boolean bl = true;

			for (Info i : queue) {
				if (info.num < i.num) {
					bl = false;
					break;
				}
			}

			if (!bl) {
				queue.add(info);
				continue;
			}

			answer++;

			if (info.location)
				break;
		}
        return answer;
    }
    
    static public class Info {
		int num;
		boolean location;

		public Info(int num, boolean location) {
			this.num = num;
			this.location = location;
		}
	}
}

 