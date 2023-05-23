class Solution {
    public int[] solution(String[] wallpaper) {
       int[][] map = new int[wallpaper.length][wallpaper[0].length()];

		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rdx = Integer.MIN_VALUE;
		int rdy = Integer.MIN_VALUE;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (wallpaper[i].charAt(j) == '#') {
					lux = Math.min(j, lux);
					luy = Math.min(i, luy);
					rdx = Math.max(j, rdx);
					rdy = Math.max(i, rdy);
				}
			}
		}

		int[] answer = { luy, lux, rdy + 1, rdx + 1 };
        return answer;
    }
}