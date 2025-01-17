import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            queue.add(i);

            while (!queue.isEmpty()) {
                int num = queue.poll();

                visit[num] = true;
                
                for (int j = 0; j < n; j++) {
                    if (computers[num][j] == 1 && !visit[j]) {
                        queue.add(j);
                    }
                }
            }

            answer++;
        }
        
        return answer;
    }
}