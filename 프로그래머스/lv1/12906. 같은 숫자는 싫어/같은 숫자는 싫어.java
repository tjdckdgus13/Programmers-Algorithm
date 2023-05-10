import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       ArrayList<Integer> al = new ArrayList<Integer>();

		int start = -1;
		for (int i = 0; i < arr.length; i++) {
			if (start != arr[i]) {
				al.add(arr[i]);
				start = arr[i];
			}
		}

		int[] answer = new int[al.size()];

		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

        return answer;
    }
}