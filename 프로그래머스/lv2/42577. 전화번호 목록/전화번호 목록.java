import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
    public boolean solution(String[] phone_book) {
        List<String> arr = Arrays.asList(phone_book);
		Collections.sort(arr);

		boolean answer = true;
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
        return answer;
    }
}