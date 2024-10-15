class Solution {
    public String solution(String my_string, int m, int c) {
        c--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i += m) {
            sb.append(my_string.charAt(c));

            c += m;
            if (c >= my_string.length()) break;
        }
        
        return sb.toString();
    }
}