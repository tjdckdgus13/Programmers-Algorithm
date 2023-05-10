class Solution {
    public int[] solution(String s) {
        
		int[] answer = { 0, 0 };
		while (!s.equals("1")) {
			answer[0]++;
			answer[1] += s.length() - s.replaceAll("0", "").length();
			s = s.replaceAll("0", "");
			s = Integer.toString(s.length(), 2);
		}
        return answer;
    }
}