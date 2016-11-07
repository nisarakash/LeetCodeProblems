/*
 * 151. Reverse Words in a String
 */


public class ReverseWordInString {
	public String reverseWords(String s) {
		if (s.length() == 0 || "".equals(s.trim())) {
			return "";
		}
		s = s.trim();
		String[] str = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = str.length - 1; i >= 0; i--) {
			if (!"".equals(str[i].trim())) {
				sb.append(str[i] + " ");
			}
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}
}
