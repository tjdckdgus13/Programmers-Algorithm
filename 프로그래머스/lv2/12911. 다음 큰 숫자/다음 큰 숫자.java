class Solution {
    public int solution(int n) {
       	String a = Integer.toBinaryString(n);
		int num = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '1') {
				num++;
			}
		}

		int count = 0;
		String check = "";
		while (num != count) {
			count = 0;
			n++;
			check = Integer.toBinaryString(n);
			for (int i = 0; i < check.length(); i++) {
				if (check.charAt(i) == '1') count++;
			}
		}
        return n;
    }
}