import java.util.ArrayList;
import java.util.List;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                list.add(todo_list[i]);
            }
        }
        String[] answer = new String[list.size()];
        int b = 0;
        for (String i : list) {
            answer[b] = i;
            b++;
        }
        return answer;
    }
}