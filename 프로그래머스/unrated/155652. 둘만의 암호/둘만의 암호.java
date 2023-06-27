import java.util.ArrayList;
import java.util.List;
class Solution {
    static List<Character> arr = new ArrayList<>();
    public String solution(String s, String skip, int index) {
        
		for (int i = 0; i < skip.length(); i++) {
			arr.add(skip.charAt(i));
		}
        
        return change(s, index);
    }
    public static String change(String str, int idx) {
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			int a = 0;
			char c = str.charAt(i);
			while (a != idx) {
				if (c == 122) {
					c = 'a';
				} else {
					c = (char) (c + 1);
				}
				if (arr.contains(c)) {
					continue;
				}
				a++;
			}
			answer += c;
		}
		return answer;
	}
}