import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int solution(int[] nums) {
        int len = nums.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					arr.add(nums[i] + nums[j] + nums[k]);
				}
			}
		}

		Collections.sort(arr);


		int arrLen = arr.get(arr.size() - 1);
		boolean[] bl = new boolean[arrLen + 1];
		bl[0] = bl[1] = true;

		for (int i = 2; i <= arrLen; i++) {
			if (bl[i])
				continue;
			for (int j = i * 2; j <= arrLen; j += i) {
				bl[j] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (!bl[arr.get(i)]) {
				answer++;
			}
		}
        return answer;
    }
}