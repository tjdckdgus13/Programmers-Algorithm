class Solution {
    public int oneCnt;
    public int zeroCnt;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        
        oneCnt = 0;
        zeroCnt = 0;
        recur(arr, 0, 0, arr.length);
        
        return new int[]{zeroCnt, oneCnt};
    }
    
    public void recur(int[][] arr, int x, int y, int n){
        int tempOneCnt = 0;
        for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(arr[i][j] == 1) tempOneCnt++;
            }
        }
        
        if(tempOneCnt == n*n){
            oneCnt++;
        } else if(tempOneCnt == 0){
            zeroCnt++;
        } else {
            recur(arr, x, y, n/2); 
            recur(arr, x, y+n/2, n/2); 
            recur(arr, x+n/2, y, n/2); 
            recur(arr, x+n/2, y+n/2, n/2); 
        }
        
    }
}