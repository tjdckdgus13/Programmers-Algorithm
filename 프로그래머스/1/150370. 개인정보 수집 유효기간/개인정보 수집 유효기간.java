import java.util.*;
import java.util.stream.Stream;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> ansList = new ArrayList<>();

        Map<String, Integer> t = new HashMap<>();
        for(String term : terms){
            String[] tmp = term.split(" ");
            t.put(tmp[0],Integer.parseInt(tmp[1]));
        }
        
        int[] todays =  Stream.of(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
        for(int i=0;i<privacies.length;i++){
            String[] dateNterm = privacies[i].split(" ");

            int[] date = Stream.of(dateNterm[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            if((date[1] += t.get(dateNterm[1])) > 12){
                if(date[1]%12==0){
                    date[0] += date[1]/12 -1;
                    date[1] = 12;
                }else{
                    date[0] += date[1]/12;
                    date[1] = date[1]%12;
                }
            }
            
            if(todays[0]>date[0] ||
                todays[0]==date[0] && todays[1]>date[1] ||
                todays[0]==date[0] && todays[1]==date[1] && todays[2]>=date[2]){
                ansList.add(i+1);
            }
            
        }
        answer = ansList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}