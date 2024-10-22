class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        
        int pow = 0;
        while(len > Math.pow(2, pow)) {
            pow++;
        }
        
        int[] answer = new int[(int)Math.pow(2, pow)];
        for(int i = 0; i < len; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }
}