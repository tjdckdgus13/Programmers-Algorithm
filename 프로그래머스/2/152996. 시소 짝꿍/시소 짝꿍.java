import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        long answer = 0;
        for (int i : weights) {
            double w = i * 1.0;

            double a = (w * 2.0) / 3.0;
            double b = (w * 3.0) / 4.0;
            double c = w / 2.0;


            if (map.containsKey(w)) answer += map.get(w);
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);

            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return answer;
    }
}