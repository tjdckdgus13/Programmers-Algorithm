class Solution {
    public String solution(String phone_number) {
       	int a = phone_number.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a - 4; i++) {
			sb.append("*");
		}
         sb.append(phone_number.substring(a - 4, a));
        return sb.toString();
    }
}