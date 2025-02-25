import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long a = 1;
        
        for(int i=1; i<=n; i++) {
            list.add(i);
            a *= i;
        }
       
        int idx = 0;
        k--; 
        while(idx < n) {
            a /= n - idx;
            answer[idx++] = list.remove((int) (k / a));
            k %= a;
        }

        return answer;
    }
}
