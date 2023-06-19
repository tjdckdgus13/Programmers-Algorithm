class Solution {
    public String solution(String p) {
        String answer = S(p);
        return answer;
    }
    public static String S(String p) {
		if (p.equals(""))
			return "";
		StringBuilder sb = new StringBuilder();
		String[] arr = separation(p);
		String u = arr[0];
		String v = arr[1];

		if (B(u)) {
			sb.append(u).append(S(v));
		} else {
			sb.append("(").append(S(v)).append(")").append(reverse(u));
		}
		return sb.toString();
	}

	public static String[] separation(String p) {
		String result = "";
		int a = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				a++;
			} else {
				a--;
			}
			if (a == 0) {
				result = p.substring(0, i + 1);
				if (p.length() > i + 1) {
					return new String[] { result, p.substring(i + 1) };
				}
				break;
			}
		}
		return new String[] { result, "" };
	}

	public static boolean B(String u) {
		int a = 0;
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				a++;
			} else {
				a--;
			}
			if (a < 0) {
				return false;
			}
		}
		return true;
	}

	public static String reverse(String v) {
		if (v.length() < 3) {
			return "";
		} else {
			v = v.substring(1, v.length() - 1);
		}
		String result = "";
		for (String i : v.split("")) {
			if (i.equals("(")) {
				result += ")";
			} else {
				result += "(";
			}
		}
		return result;
	}
}