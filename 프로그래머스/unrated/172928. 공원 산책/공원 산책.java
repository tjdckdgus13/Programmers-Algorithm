class Solution {
    public int[] solution(String[] park, String[] routes) {
       int[][] map = new int[park[0].length()][park.length];
		int[] answer = new int[2];
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {

				if (park[i].charAt(j) == 'X') {
					map[j][i] = 1;
				} else if (park[i].charAt(j) == 'S') {
					answer[0] = j;
					answer[1] = i;

				} else {
					continue;
				}
			}
		}

		int w = map.length - 1;
		int h = map[0].length - 1;

		for (int i = 0; i < routes.length; i++) {
			String op = routes[i].substring(0, 1);
			int n = Integer.parseInt(routes[i].substring(2));
			boolean bl = true;
			switch (op) {
			case "E":
				if (answer[0] + n > w)
					break;
				for (int j = 1; j <= n; j++) {
					if (map[answer[0] + j][answer[1]] == 1) {
						bl = false;
						break;
					}
				}
				if (bl) {
					answer[0] += n;
				}
				break;
			case "S":
				if (answer[1] + n > h)
					break;

				for (int j = 1; j <= n; j++) {
					if (map[answer[0]][answer[1] + j] == 1) {
						bl = false;
						break;
					}
				}

				if (bl) {
					answer[1] += n;
				}
				break;
			case "N":
				if (answer[1] - n < 0)
					break;

				for (int j = 1; j <= n; j++) {
					if (map[answer[0]][answer[1] - j] == 1) {
						bl = false;
						break;
					}
				}
				if (bl) {
					answer[1] -= n;
				}
				break;
			case "W":
				if (answer[0] - n < 0)
					break;

				for (int j = 1; j <= n; j++) {
					if (map[answer[0] - j][answer[1]] == 1) {
						bl = false;
						break;
					}
				}

				if (bl) {
					answer[0] -= n;
				}
				break;
			}
		}
		int temp = answer[0];
		answer[0] = answer[1];
		answer[1] = temp;
        return answer;
    }
}