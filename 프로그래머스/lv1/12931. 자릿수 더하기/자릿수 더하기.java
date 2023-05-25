import java.util.*;

public class Solution {
    public int solution(int n) {
        int num = 0;
		while (n != 0) {
			num += n % 10;
			n = n / 10;
		}

        return num;
    }
}