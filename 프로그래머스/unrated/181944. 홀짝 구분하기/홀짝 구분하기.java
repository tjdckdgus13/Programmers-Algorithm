import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String answer = "";
		if (n % 2 == 0) {
			answer = "" + n + " is even";
		} else {
			answer = "" + n + " is odd";
		}
        
        System.out.println(answer);
    }
}