import java.util.*;
class Solution {
    static List<String> list = new LinkedList<>();
    static String[] arr = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
    
    static void dfs(String word, int depth) {
        list.add(word);

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(word + arr[i], depth + 1);
        }
    }
}
