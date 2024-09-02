import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            } else {
                answer.append(Character.toUpperCase(c));
            }
        }
        System.out.println(answer.toString());
    }
}