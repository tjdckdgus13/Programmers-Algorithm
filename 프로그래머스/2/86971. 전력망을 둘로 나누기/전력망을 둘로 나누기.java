import java.util.*;
class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        list = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];

            list[start].add(end);
            list[end].add(start);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];

            list[start].remove(Integer.valueOf(end));
            list[end].remove(Integer.valueOf(start));

            int count = bfs(end, n);
            answer = Math.min(count, answer);

            list[start].add(end);
            list[end].add(start);
        }
        
        return answer;
    }
    
    static int bfs(int num, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited = new boolean[n + 1];
        visited[num] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int i : list[q]) {
                if (visited[i]) continue;
                visited[q] = true;
                queue.add(i);
                count++;
            }
        }


        return Math.abs(count - (n - count));
    }
}