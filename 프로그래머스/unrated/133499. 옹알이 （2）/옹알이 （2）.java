class Solution {
    public int solution(String[] babbling) {
        String[] arr = { "aya", "ye", "woo", "ma" };

		int answer = 0;
		for (int i = 0; i < babbling.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (babbling[i].contains(arr[j].repeat(2))) {
                    break;
				} else if (babbling[i].contains(arr[j])) {
					babbling[i] = babbling[i].replaceAll(arr[j], " ");
				}

			}
            babbling[i]  = babbling[i].replaceAll(" ", "");
			if (babbling[i].equals("")) {
				answer++;
			}
		}
        return answer;
    }
}