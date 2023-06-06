import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i);
		}

		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			int idx = 0;
			String str = skill_trees[i];
			boolean check = false;
			for (int j = 0; j < str.length(); j++) {
				if (map.containsKey(str.charAt(j))) {
					if (idx == map.get(str.charAt(j))) {
						idx++;
						continue;
					} else {
						check = true;
						break;
					}
				}
			}
			if (!check)
				answer++;
		}
        return answer;
    }
}