class Solution {
    public String solution(String s) {
      String[] arr = s.split(" ");

		String answer = "";
		for (String i : arr) {
			
			if (i.length() == 0) {
				answer += " ";
				continue;
			}
			
			if (Character.isDigit(i.charAt(0))) {
				answer += i.toLowerCase() + " ";
			} else {
				String a = i.substring(0, 1).toUpperCase() + i.substring(1).toLowerCase() + " ";
				answer += a;
			}
		}
        
        if (s.substring(s.length() - 1 , s.length()).equals(" ")) {
			return answer;
		} else {
			return answer = answer.substring(0, answer.length() - 1);
		}
        
      
    }
}