import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for (String str : operations) {
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (s.equals("I")) {
                queue1.add(num);
                queue2.add(num);

                continue;
            }

            if (s.equals("D")) {
                if (!queue1.isEmpty()) {
                    if (num == 1) {
                        int n = queue2.poll();
                        queue1.remove(n);
                    } else {
                        int n = queue1.poll();
                        queue2.remove(n);
                    }
                    continue;
                }
            }
        }
        
        return queue1.isEmpty() ? new int[]{0, 0} : new int[]{queue2.peek(), queue1.peek()};
    }
}