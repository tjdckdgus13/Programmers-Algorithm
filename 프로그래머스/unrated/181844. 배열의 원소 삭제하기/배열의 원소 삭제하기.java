import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> list2 = Arrays.stream(delete_list).boxed().collect(Collectors.toList());
		for (int i = 0; i < list2.size(); i++) {
			if (list1.contains(list2.get(i))) {
				list1.remove(list2.get(i));
			}
		}
		int[] answer = list1.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}