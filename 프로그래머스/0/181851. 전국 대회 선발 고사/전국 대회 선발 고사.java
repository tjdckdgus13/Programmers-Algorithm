import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int N = rank.length;
        int[] arr = new int[N + 1];

        for (int i = 0, j = 1; i < N; i++, j++) {
            arr[rank[i]] = j;
        }

        Arrays.sort(rank);

        int a = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int n = arr[rank[i]] - 1;

            if (!attendance[n]) continue;

            if (a == 0) {
                answer += 10000 * n;
                a++;
            } else if (a == 1) {
                answer += 100 * n;
                a++;
            } else {
                answer += n;
                break;
            }
        }
        
        return answer;
    }
}