import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] arr = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {
			arr[i] = strings[i].charAt(n) + strings[i].substring(0);
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(1, arr[i].length());
		}
        return arr;
    }
}