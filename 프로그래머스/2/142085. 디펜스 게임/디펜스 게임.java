import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if (k == enemy.length) return k;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            queue.add(enemy[i]);

            n -= enemy[i];

            if (n < 0) {
                if (k > 0) {
                    n += queue.poll();
                    k--;
                } else {
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}