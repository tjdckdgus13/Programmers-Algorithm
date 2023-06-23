class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int one = 0;
		int two = 0;
		if (arr1.length != arr2.length) {
            return arr1.length - arr2.length > 0 ? 1 : -1;
		} else {
			for (int i : arr1) {
				one += i;
			}
			for (int i : arr2) {
				two += i;
			}
		}
        return one - two > 0 ? 1 : one - two < 0 ? -1 : 0;
    }
}