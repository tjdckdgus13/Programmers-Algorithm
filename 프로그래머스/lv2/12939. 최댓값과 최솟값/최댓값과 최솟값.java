class Solution {
    public String solution(String s) {
        String[] a = s.split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String i : a) {
			int num = Integer.parseInt(i);
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
        return min + " " + max;
    }
}