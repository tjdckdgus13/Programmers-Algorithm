class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[names.length % 5 != 0 ? (names.length / 5) + 1 : names.length / 5];
        answer[0] = names[0];
        for (int i = 5 ,j = 1;  i < names.length; i++) {
            if(i % 5 == 0) {
                answer[j] = names[i];
                j++;
            } 
        }
        
        return answer;
    }
}