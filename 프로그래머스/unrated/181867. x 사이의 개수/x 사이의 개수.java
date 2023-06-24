class Solution {
    public int[] solution(String myString) {
        int ren = myString.replaceAll("[^x]", "").length() + 1;
		int[] answer = new int[ren];

		int count = 0;
		for (int i = 0, j = 0; i < myString.length(); i++) {
           if (i == myString.length() - 1 && myString.charAt(i) != 'x') {
				count++;
				answer[j] = count;
				break;
			}
            
			if (myString.charAt(i) == 'x') {
				answer[j] = count;
				count = 0;
				j++;
			} else {
				count++;
			}
		}
        return answer;
    }
}