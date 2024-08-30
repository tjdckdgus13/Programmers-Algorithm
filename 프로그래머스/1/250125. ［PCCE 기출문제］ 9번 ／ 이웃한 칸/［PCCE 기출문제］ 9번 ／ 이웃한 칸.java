class Solution {
    public int solution(String[][] board, int h, int w) {
        int H = board.length;
        int W = board[0].length;
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, 1, 0, -1};

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int moveX = w + X[i];
            int moveY = h + Y[i];

            if (moveX < 0 || moveX >= W || moveY < 0 || moveY >= H) continue;

            if (board[h][w].equals(board[moveY][moveX])) answer++;
        }
        return answer;
    }
}