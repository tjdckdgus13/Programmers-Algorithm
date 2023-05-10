import java.util.ArrayList;
class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> arr = new ArrayList<String>();
		arr.add(words[0]);

		int[] answer = { 0, 0 };
		for (int i = 1; i < words.length; i++) {
			if (arr.contains(words[i])) {
               	answer[0] = (i % n) + 1 ;
				answer[1] = (i / n) + 1;
				break;
			}

			if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
				answer[0] = (i % n) + 1 ;
				answer[1] = (i / n) + 1;
				break;
			} else {
				arr.add(words[i]);
			}
        }
        
        return answer;
    }
}