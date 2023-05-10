class Solution {
    public long solution(int n) {
        long[] arr = new long[n + 1];

		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}
        
        return (long)(arr[arr.length - 1] + arr[arr.length - 2]) % 1234567;
	}
}