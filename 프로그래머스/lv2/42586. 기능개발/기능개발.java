import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Info> queue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			queue.add(new Info(progresses[i], speeds[i]));
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			for (Info i : queue) {
				i.check();
			}

			int count = 0;
			int num = 0;
			Iterator<Info> it = queue.iterator();
			while (it.hasNext()) {
				if (it.next().progress >= 100) {
					num++;
					count++;
					continue;
				}
				break;
			}

			if (num != 0) {
				for (int i = 0; i < num; i++) {
					queue.poll();
				}
				list.add(count);
			}
		}
        int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
    static class Info {
		int progress;
		int speeds;

		public Info(int progress, int speeds) {
			this.progress = progress;
			this.speeds = speeds;
		}

		public void check() {
			progress += speeds;
		}
	}
}