import java.util.Stack;

class Solution {
    public int solution(String s) {
       char[] arr = new char[s.length()];
		Stack<Character> stack = new Stack<Character>();

		int answer = 0;

		for (int i = 0; i < arr.length; i++) {

			if (i != 0) {
				s = s.substring(1, s.length()) + s.substring(0, 1);
			}

			arr = s.toCharArray();

			boolean bl = true;
			for (int j = 0; j < arr.length; j++) {
				if (stack.isEmpty()) {
					stack.add(arr[j]);
					continue;
				}

				char a = stack.peek();

				switch (arr[j]) {
				case ']':
					if (a == '[') {
						stack.pop();
					} else {
                        stack.add('0');
						bl = false;
					}
                        break;
				case '}':
					if (a == '{') {
						stack.pop();
					} else {
                        stack.add('0');
						bl = false;
					}
                        break;
				case ')':
					if (a == '(') {
						stack.pop();
					} else {
                        stack.add('0');
						bl = false;
					}
                        break;
				case '(':
					stack.add(arr[j]);
					break;
				case '{':
					stack.add(arr[j]);
					break;
				case '[':
					stack.add(arr[j]);
					break;
				}

				if (bl == false)
					break;
			}

			if (stack.isEmpty()) {
				answer++;
			}

			stack.clear();
		}
        
        return answer;
    }
}