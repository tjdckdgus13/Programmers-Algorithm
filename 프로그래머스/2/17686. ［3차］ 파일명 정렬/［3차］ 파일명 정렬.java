import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        int index = 0;
        for (String file : files) {
            queue.add(new Node(file, index));
            index++;
        }

        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            Node node = queue.poll();
            answer[i] = node.file;
        }
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    String file;
    int index;

    public Node(String file, int index) {
        this.file = file;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        String head1 = file.split("[0-9]")[0].toLowerCase();
        String head2 = o.file.split("[0-9]")[0].toLowerCase();

        if (head1.compareTo(head2) == 0) {
            int number1 = getNumber(file.substring(head1.length()));
            int number2 = getNumber(o.file.substring(head2.length()));

            if (number1 == number2) {
                return Integer.compare(index, o.index);
            }

            return number1 - number2;
        }

        return head1.compareTo(head2);
    }

    public int getNumber(String body) {
        StringBuilder sb = new StringBuilder();

        for (char c : body.toCharArray()) {
            if (Character.isDigit(c) && sb.length() < 5) {
                sb.append(c);
            } else {
                return Integer.parseInt(sb.toString());
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
