import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
       ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					arr.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}
		
		int answer = 0;
		
		while (true) {
			boolean bl = true;
			for (int i = 0; i < arr.size() - 1; i++) {
				if (arr.get(i) == arr.get(i + 1)) {
					arr.remove(i + 1);
					arr.remove(i);
					answer += 2;
					bl = false;
					System.out.println(arr);
					break;
				}
			}
			if (bl == true) {
				break;
			}
		}
        return answer;
    }
}