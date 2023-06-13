class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
		int answer = 0;

		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[2]);
		switch (str[1]) {
		case "+":
			answer = a + b;
			break;
		case "-":
			answer = a - b;
			break;
		case "*":
			answer = a * b;
			break;
		}
        return answer;
    }
}