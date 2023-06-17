import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2);
			}
		});

		String answer = "";
        if (arr[0].equals("0")) return "0";
		for (String i : arr) {
			answer += i;
		}
        return answer;
    }
}