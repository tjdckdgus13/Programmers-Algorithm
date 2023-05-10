class Solution {
    public int solution(int[] arr) {
        int a = 0;
		if (arr.length == 1) {
            return arr[0];
		} else {
			 a = (arr[1] * arr[0]) / gcd(arr[1], arr[0]);

			for (int i = 2; i < arr.length; i++) {
				a = (arr[i] * a) / gcd(arr[i], a);
			}
		}
        return a;
    }
    
    static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}

		return gcd(b, a % b);
	}
}