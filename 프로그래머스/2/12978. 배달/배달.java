import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        List<Node>[] list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        boolean[] visit = new boolean[N + 1];
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int b = node.b;

            if (visit[b]) continue;

            visit[b] = true;

            for (Node i : list[b]) {
                if (dist[b] + i.weight <= dist[i.b]) {
                    dist[i.b] = dist[b] + i.weight;
                    queue.add(new Node(i.b, dist[i.b]));
                }

            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}

class Node implements Comparable<Node> {
    int b;
    int weight;

    public Node(int b, int weight) {
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}