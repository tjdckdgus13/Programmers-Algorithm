import java.util.HashSet;
class Solution {
    static int[] visit;
	static HashSet<Integer> set;
    public int solution(String numbers) {
		visit = new int[numbers.length()];
		set = new HashSet<Integer>();

		dfs("", 0, numbers);

		int answer = set.size();
        return answer;
    }
    
    public static void dfs(String str, int idx, String numbers) {
		for (int i = 0; i < numbers.length(); i++) {
			if (visit[i] == 1 || idx == str.length() - 1) {
				if (check(Integer.parseInt(str))) {
					set.add(Integer.parseInt(str));
				}
				continue;

			}
			visit[i] = 1;
			dfs(str + numbers.charAt(i), idx + 1, numbers);
			visit[i] = 0;
		}
	}

	public static boolean check(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}