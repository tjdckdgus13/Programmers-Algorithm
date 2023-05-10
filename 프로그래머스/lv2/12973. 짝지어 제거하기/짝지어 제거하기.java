import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();

		stack.add(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
				stack.add(s.charAt(i));
			} else {
				stack.pop();
			}
		}

        if (!stack.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
        
    }
}