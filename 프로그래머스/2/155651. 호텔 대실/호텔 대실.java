import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int[][] changeTime = new int[book_time.length][2];
        int book_length = book_time.length;

        for (int i = 0; i < book_length; i++) {
            int checkIn = Integer.parseInt(book_time[i][0].replace(":", ""));
            int checkOut = Integer.parseInt(book_time[i][1].replace(":", ""));

            checkOut += 10;

            if (checkOut % 100 >= 60) checkOut += 40;

            changeTime[i][0] = checkIn;
            changeTime[i][1] = checkOut;
        }

        Arrays.sort(changeTime, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < book_length; i++) {
            if (queue.isEmpty()) {
                queue.add(changeTime[i][1]);
                continue;
            }

            int timeIn = changeTime[i][0];
            int timeOut = changeTime[i][1];

            if (timeIn >= queue.peek()) {
                queue.poll();
                queue.add(timeOut);
            } else {
                queue.add(timeOut);
            }
        }
        
        return queue.size();
    }
}