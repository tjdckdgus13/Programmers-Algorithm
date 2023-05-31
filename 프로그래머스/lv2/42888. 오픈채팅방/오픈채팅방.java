import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class Solution {
    public String[] solution(String[] record) {
        Queue<String[]> queue = new LinkedList<>();
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < record.length; i++) {
			
			String[] arr = record[i].split(" ");
			String m = arr[0];
			
			if (m.equals("Change")) {
				map.put(arr[1], arr[2]);
			} else {
				queue.add(new String[] { arr[0], arr[1] });
				if (arr[0].equals("Enter")) {
					map.put(arr[1], arr[2]);
				}
			}
		}

		String[] answer = new String[queue.size()];
		for (int i = 0; i < answer.length; i++) {
			if (queue.peek()[0].equals("Enter")) {
				answer[i] = map.get(queue.poll()[1]) + "님이 들어왔습니다.";
			} else {
				answer[i] = map.get(queue.poll()[1]) + "님이 나갔습니다.";
			}
		}
        return answer;
    }
}