class Solution {
    public int solution(int a, int b) {
        String A = Integer.toString(a);
		String B = Integer.toString(b);
		int ab = Integer.parseInt((A + B));
		int ba = Integer.parseInt((B + A));

		int answer = ab >= ba ? ab : ba;
        return answer;
    }
}