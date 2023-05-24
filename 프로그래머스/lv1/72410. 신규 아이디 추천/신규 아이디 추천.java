class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
		
		new_id = new_id.replaceAll("[^-_.ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "");
		
		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}

		if (new_id.charAt(0) == '.')
			new_id = new_id.replaceFirst(".", "");
		
		if (new_id.length() != 0) {
			if (new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, new_id.length() - 1);
		}

		if (new_id.equals("")) {
			new_id = "a";
		}

		if (new_id.length() >= 16)
			new_id = new_id.substring(0, 15);

		if (new_id.charAt(new_id.length() - 1) == '.')
			
			new_id = new_id.substring(0, new_id.length() - 1);
		if (new_id.length() < 3) {
			if (new_id.length() == 1) {
				new_id = new_id + new_id.repeat(2);
			} else {
				new_id = new_id + new_id.charAt(1);
			}
		}
        return new_id;
    }
}