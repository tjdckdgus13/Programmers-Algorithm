import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
       
     	for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], 1);
		}
        
        int b = nums.length / 2;
		if (b < hm.size()) {
			return b;
		} else {
			return hm.size();
		}
        
    }
}