import java.util.Stack;
class Solution {
    boolean solution(String s) {
       	Stack<Character> stack = new Stack<Character>();
		boolean bl = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.add('(');
			} else {
				if (stack.isEmpty()) {
					bl = false;
					break;
				}
				
				stack.pop();
			}
		}
		
		if (!stack.isEmpty()) {
			bl = false;
		}

        return bl;
    }
}