class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right;
        int sum = 0;
        int len = -1;
        int[] answer = new int[2];
        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (len == -1 || len > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    len = right - left;
                }
            }
        }
        return answer;
    }
}