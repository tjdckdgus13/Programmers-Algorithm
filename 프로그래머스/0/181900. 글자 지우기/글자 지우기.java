import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String[] my_string_arr = my_string.split("");
        for(int i=0; i<indices.length; i++){
            my_string_arr[indices[i]] = "";
        }
        return String.join("",my_string_arr);
    }
}