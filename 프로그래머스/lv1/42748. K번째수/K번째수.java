import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int a = commands[i][0];
			int b = commands[i][1];
			
			int[] arr = new int[b - a + 1];
			int count = 0;
			for (int j = a - 1; j < b; j++) {
				arr[count] = array[j];
				count++;
				
			}
			Arrays.sort(arr);
			answer[i] = arr[commands[i][2] - 1];
		}
        return answer;
    }
}