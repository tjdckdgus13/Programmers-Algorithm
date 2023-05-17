import java.util.ArrayList;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = l; i <= r; i++) {
			if (i % 5 == 0) {
				String num = Integer.toString(i);
				num = num.replaceAll("5", "");
				num = num.replaceAll("0", "");
				if (num.equals("")) {
					list.add(i);
				}
			}
		}
		int answer[];

		if (list.size() == 0) {
			answer = new int[] { -1 };
		} else {
			answer = list.stream().mapToInt(i -> i).toArray();
		}
        
        return answer;
    }
}