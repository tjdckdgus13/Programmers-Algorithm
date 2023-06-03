import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
		Map<String, Integer> car = new TreeMap<>(comparator);
		Map<String, Integer> fee = new HashMap<>();

		int end = (23 * 60) + 59;

		for (int i = 0; i < records.length; i++) {
			String[] record = records[i].split(" ");
			String[] times = record[0].split(":");
			String number = record[1];
			int time = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
			if (record[2].equals("IN")) {
				if (time == 0) {
					car.put(number, -1);
				} else {
					car.put(number, time);
				}
				if (!fee.containsKey(number))
					fee.put(number, 0);
				continue;
			}

			int f = time - car.get(number);
			fee.put(number, fee.get(number) + f);
			car.put(number, 0);
		}

		int[] answer = new int[car.size()];
		int j = 0;
		for (Map.Entry<String, Integer> i : car.entrySet()) {
			String k = i.getKey();
			int a = end - car.get(k);
			if (car.get(k) > 0) {
				fee.put(k, fee.get(k) + a);
			} else if (car.get(k) == -1) {
				fee.put(k, end);
			}
			int v = fee.get(k);
			answer[j] = v > fees[0] ? fees[1] + (int) Math.ceil(((v - fees[0]) / (double) fees[2])) * fees[3] : fees[1];
			j++;
		}
        return answer;
    }
}