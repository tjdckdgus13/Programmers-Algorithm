class Solution {
    public int solution(String s) {
        
        if (s.length() == 1) return 1;
        
        int len = 1;
		int check = 0;
		char start = s.charAt(0);
		int answer = 0;
		for (int i = 1; i < s.length(); i++) {
            if (s.length() - 1 == i && len != 0) {
				answer++;
				break;
			}
			if (start == ' ') {
                if (s.length() - 1 == i) {
					answer++;
					break;
				}
				start = s.charAt(i);
                len = 1;
				continue;
			} else if (start == s.charAt(i)) {
				len++;
				continue;
			} else {
				check++;
			}
			if (len == check) {
				len = 0;
				check = 0;
				start = ' ';
				answer++;
			}
		}
        return answer;
    }
}