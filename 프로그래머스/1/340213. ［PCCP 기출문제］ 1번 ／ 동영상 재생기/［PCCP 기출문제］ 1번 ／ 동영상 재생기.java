class Solution {
    public int second(String time) {
        String[] a = time.split(":");
        int m = Integer.parseInt(a[0]);
        int s = Integer.parseInt(a[1]);
        return m*60+s;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int currentPos = second(pos);
        int videoLen = second(video_len);
        int opStart = second(op_start);
        int opEnd = second(op_end);
        
        for (String command : commands) {
            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
            if (command.equals("prev")) {           
                currentPos -= 10;
                if (currentPos < 0){
                    currentPos = 0;
                }
            } else {
                currentPos += 10;
                if (currentPos > videoLen){
                    currentPos = videoLen;
                }
            }
            if (currentPos >= opStart && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }

        int m = currentPos / 60;
        int s = currentPos % 60;
        return String.format("%02d:%02d", m,s);
    }
}