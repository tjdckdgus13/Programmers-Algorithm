import java.util.ArrayList;
import java.util.Collections;
class Solution {
    
    static int[] visits;
	static ArrayList<String> arr = new ArrayList<String>();
    
    public String[] solution(String[][] tickets) {
        visits = new int[tickets.length];
		bfs("ICN", "ICN", 0, tickets);

		String a = arr.get(0);
		String[] answer = a.split(" ");
		
		return answer;
    }
    
    public static void bfs(String start, String result, int index, String[][] tickets) {

		if (index == tickets.length) {
			arr.add(result);
			Collections.sort(arr);
		}

		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && visits[i] == 0) {
				visits[i] = 1;
				bfs(tickets[i][1], result + " " + tickets[i][1], index + 1, tickets);
				visits[i] = 0;
			}
		}
	}
}