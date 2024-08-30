import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
       int finish = attacks[attacks.length - 1][0];
        int hp = health;
        int time = 0;
        int idx = 0;
        for (int i = 1; i <= finish; i++) {
            if (attacks[idx][0] == i) {
                hp -= attacks[idx][1];
                idx++;
                time = 0;
                continue;
            }

            if (hp <= 0) break;

            hp = Math.min(hp + bandage[1], health);
            time++;
            if (time == bandage[0]) {
                hp = Math.min(hp + bandage[2], health);
                time = 0;
            }
        }

        int answer = hp <= 0 ? -1 : hp;
        return answer;
    }
}