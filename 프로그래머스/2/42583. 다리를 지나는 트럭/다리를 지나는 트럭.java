import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int sum_weights = 0;
        int time = 0;
        for (int truck : truck_weights) {

            while (true)
                if (queue.isEmpty()) {
                    queue.add(truck);
                    time++;
                    sum_weights += truck;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum_weights -= queue.poll();
                } else {
                    if (sum_weights + truck > weight) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(truck);
                        sum_weights += truck;
                        time++;
                        break;
                    }
                }
        }
        
        return time + bridge_length;
    }
}