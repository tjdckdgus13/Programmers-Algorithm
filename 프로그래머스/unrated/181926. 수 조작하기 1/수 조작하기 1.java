class Solution {
    public int solution(int n, String control) {
       	int count = control.length();
		int w = count - control.replace("w", "").length();
		int s = count - control.replace("s", "").length();
		int d = count - control.replace("d", "").length();
		int a = count - control.replace("a", "").length();

		n += w + (d * 10) - (a * 10) - s;
        return n;
    }
}