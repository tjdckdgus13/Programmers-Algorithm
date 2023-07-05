import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<int[]> stack = new Stack<>();

        stack.add(new int[] { 0, numbers[0] });
        for (int i = 1; i < numbers.length; i++) {
            while (true) {
                if (stack.size() == 0) {
                    stack.add(new int[] { i, numbers[i] });
                    break;
                }
                int[] a = stack.peek();
                if (a[1] >= numbers[i]) {
                    stack.add(new int[] { i, numbers[i] });
                    break;
                } else {
                    answer[a[0]] = numbers[i];
                    stack.pop();
                }
            }
        }

        int count = stack.size();
        for (int j = 0; j < count; j++) {
            int[] a = stack.pop();
            answer[a[0]] = -1;
        }
        return answer;
    }
}