class Solution {
    public int solution(int[] num_list) {
        int s = 0;
		int m = 1;
		for (int i : num_list) {
			s += i;
			m *= i;
		}
		s = s * s;
        return s > m ? 1 : 0;
    }
}