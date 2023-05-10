class Solution {
    static int answer;
	static int[] visit;
    public int solution(String begin, String target, String[] words) {
        visit = new int[words.length];
		bfs(begin, target, words, 0);
		return answer;
    }
    
    public static void bfs(String begin, String target, String[] words, int num) {
		if (target.equals(begin)) {
			answer = num;
			return;
		}
		for (int i = 0; i < words.length; i++) {
			if (visit[i] == 1) {
				continue;
			}
			int a = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (words[i].charAt(j) == begin.charAt(j)) {
					a++;
				}
			}

			if (a == begin.length() - 1) {
				visit[i] = 1;
				bfs(words[i], target, words, num + 1);
				visit[i] = 0;
			}
		}
	}
}