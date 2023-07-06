import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<Integer>();
		String[] a = s.split(" ");
		for (int i = 0; i < a.length; i++) {
			list.add(Integer.parseInt(a[i]));
		}
		Collections.sort(list);
		String answer = list.get(0) + " " + list.get(list.size() - 1);
        return answer;
    }
}