import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int count = Integer.MIN_VALUE;
        for (int[] i : routes) {
            if (count < i[0]) {
                count = i[1];
                answer++;
            }
        }
        return answer;
    }
}