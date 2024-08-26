import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], new HashMap<>());
            count.put(friends[i], 0);
        }

        StringTokenizer st;
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);

            String a = st.nextToken();
            String b = st.nextToken();

            map.get(a).put(b, map.get(a).getOrDefault(b, 0) + 1);
            count.put(a, count.get(a) + 1);
            count.put(b, count.get(b) - 1);
        }

        int[] arr = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (i == j) continue;

                int give = map.get(friends[i]).getOrDefault(friends[j], 0);
                int receive = map.get(friends[j]).getOrDefault(friends[i], 0);

                if (give > receive) {
                    arr[i]++;
                } else if (give < receive){
                    arr[j]++;
                } else {
                    if (count.get(friends[i]) > count.get(friends[j])) {
                        arr[i]++;
                    } else if (count.get(friends[i]) < count.get(friends[j])) {
                        arr[j]++;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(arr[i], answer);
        }
        return answer;
    }
}