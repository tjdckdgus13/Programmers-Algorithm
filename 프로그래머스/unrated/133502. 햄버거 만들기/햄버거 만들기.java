import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
		int answer = 0;
		for (int i : ingredient) {
			list.add(i);

			if (list.size() > 3) {
				int size = list.size();
				if (list.get(size - 1) == 1 && list.get(size - 2) == 3 && list.get(size - 3) == 2
						&& list.get(size - 4) == 1) {
					answer++;
					list.remove(size - 1);
					list.remove(size - 2);
					list.remove(size - 3);
					list.remove(size - 4);
				}
			}
		}
        return answer;
    }
}