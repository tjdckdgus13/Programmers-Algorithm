import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Top> s = new Stack<Top>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (s.isEmpty()) {
				sb.append("0 ");
				s.push(new Top(i, num));
			} else {
				while (true) {
					if (s.isEmpty()) {
						sb.append("0 ");
						s.push(new Top(i, num));
						break;
					}

					Top top = s.peek();

					if (top.height > num) {
						sb.append(top.num + " ");
						s.push(new Top(i, num));
						break;
					} else {
						s.pop();
					}
				}
			}
		}
		System.out.println(sb);

	}

}

class Top {

	int num;
	int height;

	Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}
