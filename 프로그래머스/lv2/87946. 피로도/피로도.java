class Solution {
    static int[] visit;
	static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visit = new int[dungeons.length];
		dfs(0, k, dungeons);
        return answer;
    }
    
    public static void dfs(int index, int k, int[][] dungeons) {
            for (int i = 0; i < dungeons.length; i++) {
			if (visit[i] == 1 || dungeons[i][0] > k) {
				continue;
			}
            
			visit[i] = 1;
			dfs(index + 1, k - dungeons[i][1], dungeons);
			visit[i] = 0;
		}
        
		answer = Math.max(index, answer);
	}
}