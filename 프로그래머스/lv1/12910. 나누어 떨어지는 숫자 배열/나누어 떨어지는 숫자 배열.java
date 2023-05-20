import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        
		for (int i : arr) {
			if (i % divisor == 0) {
				a.add(i);
			}
		}
		if (a.size() == 0)  {
            int[] answer = {-1};
            return answer;
        }    
        
		Collections.sort(a);
		int[] answer = new int[a.size()];
        
		for (int i = 0; i < a.size(); i++) {
			answer[i] = a.get(i);
		}
        
        return answer;
    }
}