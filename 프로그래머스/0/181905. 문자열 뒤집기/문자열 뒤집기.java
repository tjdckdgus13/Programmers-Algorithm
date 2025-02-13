class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string, s, e + 1);
        
        String str = sb.toString();
        String strReverse = sb.reverse().toString();
        
        return my_string.replaceAll(str, strReverse);
    }
}